package com.example.BackendBaseDatos.config;

import com.example.BackendBaseDatos.dominio.Actor;
import com.example.BackendBaseDatos.dominio.Director;
import com.example.BackendBaseDatos.dominio.Pelicula;
import com.example.BackendBaseDatos.repositorio.ActorRepository;
import com.example.BackendBaseDatos.repositorio.DirectorRepository;
import com.example.BackendBaseDatos.repositorio.PeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;



import java.util.List;

@Component // ⬅️ SIN ESTO, SPRING IGNORA ESTA CLASE COMPLETAMENTE
@Profile("!test")

@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepo;
    private final ActorRepository actorRepo;
    private final DirectorRepository directorRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Intentando cargar datos de prueba...");

        // Usamos saveAll para insertar en bloque, es más eficiente y seguro
        if (peliculaRepo.count() == 0) {
            peliculaRepo.saveAll(List.of(
                    new Pelicula(null, "Matrix", "Ciencia Ficción", 1999, "Oscura"),
                    new Pelicula(null, "Inception", "Ciencia Ficción", 2010, "Surrealista"),
                    new Pelicula(null, "El Padrino", "Crimen", 1972, "Clásica"),
                    new Pelicula(null, "Interstellar", "Ciencia Ficción", 2014, "Espacial"),
                    new Pelicula(null, "Pulp Fiction", "Crimen", 1994, "No lineal"),
                    new Pelicula(null, "El Caballero Oscuro", "Acción", 2008, "Oscura"),
                    new Pelicula(null, "Forrest Gump", "Drama", 1994, "Emotiva"),
                    new Pelicula(null, "Gladiator", "Acción", 2000, "Épica"),
                    new Pelicula(null, "Parasite", "Thriller", 2019, "Crítica social"),
                    new Pelicula(null, "Blade Runner 2049", "Ciencia Ficción", 2017, "Cyberpunk")
            ));
        }

        if (actorRepo.count() == 0) {
            actorRepo.saveAll(List.of(
                    new Actor(null, "Keanu Reeves", "Libanés/Canadiense"),
                    new Actor(null, "Leonardo DiCaprio", "Estadounidense"),
                    new Actor(null, "Meryl Streep", "Estadounidense"),
                    new Actor(null, "Tom Hanks", "Estadounidense"),
                    new Actor(null, "Penélope Cruz", "Española"),
                    new Actor(null, "Robert De Niro", "Estadounidense"),
                    new Actor(null, "Scarlett Johansson", "Estadounidense"),
                    new Actor(null, "Denzel Washington", "Estadounidense"),
                    new Actor(null, "Margot Robbie", "Australiana"),
                    new Actor(null, "Ricardo Darín", "Argentino")
            ));
        }

        if (directorRepo.count() == 0) {
            directorRepo.saveAll(List.of(
                    new Director(null, "Lana Wachowski", 58),
                    new Director(null, "Christopher Nolan", 53),
                    new Director(null, "Steven Spielberg", 77),
                    new Director(null, "Quentin Tarantino", 61),
                    new Director(null, "Martin Scorsese", 81),
                    new Director(null, "Greta Gerwig", 40),
                    new Director(null, "Pedro Almodóvar", 74),
                    new Director(null, "Guillermo del Toro", 59),
                    new Director(null, "Denis Villeneuve", 56),
                    new Director(null, "Bong Joon-ho", 54)
            ));
        }

        System.out.println("✅ DATOS CARGADOS CON ÉXITO");
    }
}