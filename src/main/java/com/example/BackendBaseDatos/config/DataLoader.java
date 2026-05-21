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

@Component
//@Profile("!test")
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepo;
    private final ActorRepository actorRepo;
    private final DirectorRepository directorRepo;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("🚀 Intentando cargar datos de prueba...");

        if (peliculaRepo.count() == 0) {

            Director director1 = new Director();
            director1.setNombre("Lana Wachowski");
            director1.setEdad(58);

            Director director2 = new Director();
            director2.setNombre("Christopher Nolan");
            director2.setEdad(53);

            Director director3 = new Director();
            director3.setNombre("Jonathan Nolan");
            director3.setEdad(48);

            directorRepo.saveAll(List.of(director1, director2, director3));

            Pelicula pelicula1 = new Pelicula();
            pelicula1.setTitulo("Matrix");
            pelicula1.setGenero("Ciencia Ficción");
            pelicula1.setAnio(1999);
            pelicula1.setCategoriaVisual("Oscura");
            pelicula1.setDirectores(List.of(director1));

            Pelicula pelicula2 = new Pelicula();
            pelicula2.setTitulo("Interstellar");
            pelicula2.setGenero("Ciencia Ficción");
            pelicula2.setAnio(2014);
            pelicula2.setCategoriaVisual("Espacial");
            pelicula2.setDirectores(List.of(director2, director3));

            peliculaRepo.saveAll(List.of(pelicula1, pelicula2));

            Actor actor1 = new Actor();
            actor1.setNombre("Keanu Reeves");
            actor1.setNacionalidad("Libanés/Canadiense");
            actor1.setPelicula(pelicula1);

            Actor actor2 = new Actor();
            actor2.setNombre("Carrie-Anne Moss");
            actor2.setNacionalidad("Canadiense");
            actor2.setPelicula(pelicula1);

            Actor actor3 = new Actor();
            actor3.setNombre("Matthew McConaughey");
            actor3.setNacionalidad("Estadounidense");
            actor3.setPelicula(pelicula2);

            Actor actor4 = new Actor();
            actor4.setNombre("Anne Hathaway");
            actor4.setNacionalidad("Estadounidense");
            actor4.setPelicula(pelicula2);

            actorRepo.saveAll(List.of(actor1, actor2, actor3, actor4));
        }

        System.out.println("✅ DATOS CARGADOS CON ÉXITO");
    }
}
