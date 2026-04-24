package com.example.BackendBaseDatos.repositorio;

import com.example.BackendBaseDatos.dominio.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
/*package com.example.BackendBaseDatos.repositorio;

import com.example.BackendBaseDatos.dominio.Director;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DirectorRepository {

    private final ArrayList<Director> directores = new ArrayList<>();

    public DirectorRepository() {
        directores.add(new Director(1L, "Chris Columbus", 66));
        directores.add(new Director(2L, "Alfonso Cuarón", 64));
        directores.add(new Director(3L, "David Yates", 61));
    }

    public ArrayList<Director> mostrar_directores() {
        return directores;
    }

    public Director addDirector(Director d){
        directores.add(d);
        return d;
    }
}*/