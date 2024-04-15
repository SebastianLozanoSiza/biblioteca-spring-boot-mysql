package com.sebas.demo.repositories.entities;

import java.io.Serializable;
import java.util.Date;

import com.sebas.demo.resources.EstadoPrestamo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prestamos")
public class Prestamo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @JoinColumn(name = "id_libro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Libro libro;

    @NotNull(message = "La fecha de prestamo no puede estar vacia")
    @Column(nullable = false, name = "fecha_prestamo")
    private Date fechaPrestamo;

    @NotNull(message = "La fecha de devolucion no puede estar vacia")
    @Column(nullable = false, name = "fecha_devolucion")
    private Date fechaDevolucion;

    @Enumerated(EnumType.ORDINAL)
    private EstadoPrestamo estadoPrestamo;

}
