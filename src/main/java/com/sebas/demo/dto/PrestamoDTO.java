package com.sebas.demo.dto;

import java.util.Date;

import com.sebas.demo.resources.EstadoPrestamo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDTO {

    private Long id;
    private Long usuarioId;
    private Long libroId;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private EstadoPrestamo estadoPrestamo;
}
