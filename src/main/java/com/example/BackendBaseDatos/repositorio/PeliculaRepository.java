package com.example.BackendBaseDatos.repositorio;

import com.example.BackendBaseDatos.dominio.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
/*package com.example.BackendBaseDatos.repositorio;

import com.example.BackendBaseDatos.dominio.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class PeliculaRepository {

    private final ArrayList<Pelicula> peliculas = new ArrayList<>();

    public PeliculaRepository() {
        peliculas.add(new Pelicula(1L,"Harry Potter y la piedra filosofal","Fantasía",2001));
        peliculas.add(new Pelicula(2L,"Harry Potter y la cámara secreta","Fantasía",2002));
        peliculas.add(new Pelicula(3L,"Harry Potter y el prisionero de Azkaban","Fantasía",2004));

    }
    public ArrayList<Pelicula>  mostrar_peliculas() {
        return peliculas;
    }

    public Pelicula addPelicula(Pelicula p){
        peliculas.add(p);
        return p;
    }

}*/

