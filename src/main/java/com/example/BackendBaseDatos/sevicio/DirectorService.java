package com.example.BackendBaseDatos.sevicio;

import com.example.BackendBaseDatos.dominio.Director;
import com.example.BackendBaseDatos.repositorio.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorService {

    private final DirectorRepository repository;

    public List<Director> obtenerDirectores() {
        return repository.findAll();
    }

    public Director addDirector(Director d){
        return repository.save(d);
    }

    public Director actualizar(Long id, Director directorActualizado) {

        Director directorExistente = repository.findById(id).orElse(null);

        if (directorExistente != null) {

            if (directorActualizado.getNombre() != null) {
                directorExistente.setNombre(directorActualizado.getNombre());
            }

            // int no puede ser null → no se comprueba como objeto
            if (directorActualizado.getEdad() != 0) {
                directorExistente.setEdad(directorActualizado.getEdad());
            }

            return repository.save(directorExistente);
        }

        return null;
    }

    public void eliminar(Long id) {
        // Validar siempre evita "peta" la app
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            // En un caso real diríamos al usuario:
            // "El director no existe"
            System.out.println("El director con ID " + id + " no existe.");
        }
    }
}