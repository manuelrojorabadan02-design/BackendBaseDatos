package com.example.BackendBaseDatos.controlador;

import com.example.BackendBaseDatos.dominio.Actor;
import com.example.BackendBaseDatos.sevicio.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actores")
public class ActorControler {

    private final ActorService actorService;

    @GetMapping
    public List<Actor> obtenerActor() {
        return actorService.obtenerActor();
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor a){
        return actorService.addActor(a);
    }

    @PutMapping("/{id}")
    public Actor actualizarActor(
            @PathVariable Long id,
            @RequestBody Actor actorActualizado) {

        return actorService.actualizar(id, actorActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        actorService.eliminar(id);
    }
}