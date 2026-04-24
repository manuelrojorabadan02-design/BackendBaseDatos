package com.example.BackendBaseDatos.controlador;

import com.example.BackendBaseDatos.dominio.Director;
import com.example.BackendBaseDatos.sevicio.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/directores")
public class DirectorControler {

    private final DirectorService directorService;

    @GetMapping
    public List<Director> obtenerDirectores() {
        return directorService.obtenerDirectores();
    }

    @PostMapping
    public Director addDirector(@RequestBody Director d){
        return directorService.addDirector(d);
    }

    @PutMapping("/{id}")
    public Director actualizarDirector(
            @PathVariable Long id,
            @RequestBody Director directorActualizado){

        return directorService.actualizar(id, directorActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        directorService.eliminar(id);
    }

}