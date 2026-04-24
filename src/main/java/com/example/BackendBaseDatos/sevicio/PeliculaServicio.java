package com.example.BackendBaseDatos.sevicio;

import com.example.BackendBaseDatos.dominio.Pelicula;
import com.example.BackendBaseDatos.repositorio.PeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeliculaServicio {

    private final PeliculaRepository repository;

    public List<Pelicula> obtenerTodas() {
        return repository.findAll();
    }

    public Pelicula addPelicula(Pelicula p){
        return repository.save(p);
    }

    public Pelicula actualizar(Long id, Pelicula peliculaActualizada) {

        Pelicula peliculaExistente = repository.findById(id).orElse(null);

        if (peliculaExistente != null) {

            if (peliculaActualizada.getTitulo() != null) {
                peliculaExistente.setTitulo(peliculaActualizada.getTitulo());
            }

            if (peliculaActualizada.getGenero() != null) {
                peliculaExistente.setGenero(peliculaActualizada.getGenero());
            }

            // int → no nullable
            if (peliculaActualizada.getAnio() != 0) {
                peliculaExistente.setAnio(peliculaActualizada.getAnio());
            }

            return repository.save(peliculaExistente);
        }

        return null;
    }

    public void eliminar(Long id) {
        // Validar siempre evita "peta" la app
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            // En un caso real diríamos al usuario:
            // "La película no existe"
            System.out.println("La película con ID " + id + " no existe.");
        }
    }
}