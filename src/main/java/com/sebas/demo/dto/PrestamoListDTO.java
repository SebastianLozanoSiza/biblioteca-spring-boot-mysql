package com.sebas.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoListDTO {
    
    private Long id;
    private String nombreUsuario;
    private String nombreLibro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estadoPrestamo;

    
}
