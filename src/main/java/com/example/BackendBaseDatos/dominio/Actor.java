package com.example.BackendBaseDatos.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Soy un elemento auto increment
    //atributos
    private Long id;
    private String nombre;
    private String nacionalidad;


}