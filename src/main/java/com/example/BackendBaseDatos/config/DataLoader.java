package com.example.BackendBaseDatos.config;

import com.example.BackendBaseDatos.dominio.Actor;
import com.example.BackendBaseDatos.dominio.Director;
import com.example.BackendBaseDatos.dominio.Pelicula;
import com.example.BackendBaseDatos.repositorio.ActorRepository;
import com.example.BackendBaseDatos.repositorio.DirectorRepository;
import com.example.BackendBaseDatos.repositorio.PeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepo;
    private final ActorRepository actorRepo;
    private final DirectorRepository directorRepo;

    @Override
    public void run(String... args) throws Exception {

        // Cargamos Directores si no hay ninguno
        if (directorRepo.count() == 0) {
            directorRepo.save(new Director(null, "Christopher Nolan", 5));
            directorRepo.save(new Director(null, "Steven Spielberg", 12));
        }

        // Cargamos Actores
        if (actorRepo.count() == 0) {
            actorRepo.save(new Actor(null, "Cillian Murphy", "Irlandesa"));
            actorRepo.save(new Actor(null, "Tom Hardy", "Británica"));
        }

        // Cargamos Películas (usando los datos que tenías en comentarios)
        if (peliculaRepo.count() == 0) {
            peliculaRepo.save(new Pelicula(null, "Harry Potter y la piedra filosofal", "Fantasía", 2001));
            peliculaRepo.save(new Pelicula(null, "Inception", "Ciencia Ficción", 2010));
        }

        System.out.println("--- Datos iniciales cargados con éxito ---");
    }
}