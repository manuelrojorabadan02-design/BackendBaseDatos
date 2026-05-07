package com.example.BackendBaseDatos.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actores")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Soy un elemento auto increment
    //atributos
    private Long id;
    private String nombre;
    private String nacionalidad;


}