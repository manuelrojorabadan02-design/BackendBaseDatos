package com.example.BackendBaseDatos.dominio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BD_peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max=100)
    private String titulo;

    private String genero;

    @Max(2030)
    @Min(1895)
    private int anio;

    @Transient
    private String categoriaVisual;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Actor> actores = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "BD_peliculas_directores",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<Director> directores = new ArrayList<>();
}