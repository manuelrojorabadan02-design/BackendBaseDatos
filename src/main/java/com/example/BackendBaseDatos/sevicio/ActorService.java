package com.example.BackendBaseDatos.sevicio;

import com.example.BackendBaseDatos.dominio.Actor;
import com.example.BackendBaseDatos.repositorio.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorService {

    private final ActorRepository repository;

    public List<Actor> obtenerActor() {
        return repository.findAll()/*mostrar_actor()*/;
    }

    public Actor addActor(Actor a){
        return repository.save(a)/*addActor(a)*/;
    }

    public Actor actualizar(Long id, Actor actorActualizado) {

        // 1. Buscamos el actor en la BD
        Actor actorExistente = repository.findById(id).orElse(null);

        if (actorExistente != null) {

            // 2. Actualización parcial (solo campos no nulos)
            if (actorActualizado.getNombre() != null) {
                actorExistente.setNombre(actorActualizado.getNombre());
            }

            if (actorActualizado.getNacionalidad() != null) {
                actorExistente.setNacionalidad(actorActualizado.getNacionalidad());
            }

            // 3. Guardamos cambios (UPDATE)
            return repository.save(actorExistente);
        }

        // 4. Si no existe, devolvemos null (o podrías lanzar excepción)
        return null;
    }

    public void eliminar(Long id) {
        // Validar siempre evita "peta" la app
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            // En un caso real diríamos al usuario:
            // "El actor no existe"
            System.out.println("El actor con ID " + id + " no existe.");
        }
    }
}
