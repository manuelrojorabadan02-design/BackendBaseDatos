package com.example.BackendBaseDatos.repositorio;

import com.example.BackendBaseDatos.dominio.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}


/*package com.example.BackendBaseDatos.repositorio;

import com.example.BackendBaseDatos.dominio.Actor;
import com.example.BackendBaseDatos.dominio.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class ActorRepository {

    private final ArrayList<Actor> actores = new ArrayList<>();

    public ActorRepository() {
        actores.add(new Actor(1L, "Daniel Radcliffe", "Británica"));
        actores.add(new Actor(2L, "Emma Watson", "Británica"));
        actores.add(new Actor(3L, "Rupert Grint", "Británica"));
    }
    public ArrayList<Actor>  mostrar_actor() {
        return actores;
    }

    public Actor addActor(Actor a){
        actores.add(a);
        return a;
    }
}
*/