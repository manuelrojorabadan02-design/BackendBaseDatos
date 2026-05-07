package com.example.BackendBaseDatos.controlador;

import com.example.BackendBaseDatos.dominio.Pelicula;
import com.example.BackendBaseDatos.servicio.PeliculaServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/peliculas")
public class PeliculasControler {

    private final PeliculaServicio peliculaServicio;

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return peliculaServicio.obtenerTodas();
    }

    @PostMapping
    public Pelicula addPelicula(@Valid @RequestBody Pelicula p){
        return peliculaServicio.addPelicula(p);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(
            @PathVariable Long id,
            @RequestBody Pelicula peliculaActualizada){

        return peliculaServicio.actualizar(id, peliculaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        peliculaServicio.eliminar(id);
    }
}