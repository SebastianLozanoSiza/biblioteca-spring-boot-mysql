package com.sebas.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private Date añoPublicacion;
    private int cantidadDisponible;
    
}
