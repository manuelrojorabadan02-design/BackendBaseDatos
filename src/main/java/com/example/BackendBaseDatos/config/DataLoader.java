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

        // --- 10 PELÍCULAS ---
        if (peliculaRepo.count() == 0) {
            // Constructor: (id, titulo, genero, anio)
            peliculaRepo.save(new Pelicula(null, "Matrix", "Ciencia Ficción", 1999));
            peliculaRepo.save(new Pelicula(null, "Inception", "Ciencia Ficción", 2010));
            peliculaRepo.save(new Pelicula(null, "El Padrino", "Crimen", 1972));
            peliculaRepo.save(new Pelicula(null, "Interstellar", "Ciencia Ficción", 2014));
            peliculaRepo.save(new Pelicula(null, "Pulp Fiction", "Crimen", 1994));
            peliculaRepo.save(new Pelicula(null, "El Caballero Oscuro", "Acción", 2008));
            peliculaRepo.save(new Pelicula(null, "Forrest Gump", "Drama", 1994));
            peliculaRepo.save(new Pelicula(null, "Gladiator", "Acción", 2000));
            peliculaRepo.save(new Pelicula(null, "Parasite", "Thriller", 2019));
            peliculaRepo.save(new Pelicula(null, "Blade Runner 2049", "Ciencia Ficción", 2017));
        }

        // --- 10 ACTORES ---
        if (actorRepo.count() == 0) {
            // Constructor: (id, nombre, nacionalidad)
            actorRepo.save(new Actor(null, "Keanu Reeves", "Libanés/Canadiense"));
            actorRepo.save(new Actor(null, "Leonardo DiCaprio", "Estadounidense"));
            actorRepo.save(new Actor(null, "Meryl Streep", "Estadounidense"));
            actorRepo.save(new Actor(null, "Tom Hanks", "Estadounidense"));
            actorRepo.save(new Actor(null, "Penélope Cruz", "Española"));
            actorRepo.save(new Actor(null, "Robert De Niro", "Estadounidense"));
            actorRepo.save(new Actor(null, "Scarlett Johansson", "Estadounidense"));
            actorRepo.save(new Actor(null, "Denzel Washington", "Estadounidense"));
            actorRepo.save(new Actor(null, "Margot Robbie", "Australiana"));
            actorRepo.save(new Actor(null, "Ricardo Darín", "Argentino"));
        }

        // --- 10 DIRECTORES ---
        if (directorRepo.count() == 0) {
            // Constructor: (id, nombre, edad)
            directorRepo.save(new Director(null, "Lana Wachowski", 58));
            directorRepo.save(new Director(null, "Christopher Nolan", 53));
            directorRepo.save(new Director(null, "Steven Spielberg", 77));
            directorRepo.save(new Director(null, "Quentin Tarantino", 61));
            directorRepo.save(new Director(null, "Martin Scorsese", 81));
            directorRepo.save(new Director(null, "Greta Gerwig", 40));
            directorRepo.save(new Director(null, "Pedro Almodóvar", 74));
            directorRepo.save(new Director(null, "Guillermo del Toro", 59));
            directorRepo.save(new Director(null, "Denis Villeneuve", 56));
            directorRepo.save(new Director(null, "Bong Joon-ho", 54));
        }

        System.out.println("✅ DATOS DE PRUEBA CARGADOS CORRECTAMENTE");
    }
}