package com.sebas.demo.repositories.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libros")
public class Libro implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El titulo no puede estar vacio")
    @Column(nullable = false)
    private String titulo;

    @NotEmpty(message = "El autor no puede estar vacio")
    @Column(nullable = false)
    private String autor;

    @NotEmpty(message = "El genero no puede estar vacio")
    @Column(nullable = false)
    private String genero;

    @NotNull(message = "El año de publicación no puede estar vacío")
    @Column(nullable = false, name = "publicacion")
    private Date añoPublicacion;

    @Min(value = 0, message = "La cantidad disponible debe ser mayor o igual a cero")
    @Column(nullable = false, name = "cantidad_disponible")
    private int cantidadDisponible;
}
