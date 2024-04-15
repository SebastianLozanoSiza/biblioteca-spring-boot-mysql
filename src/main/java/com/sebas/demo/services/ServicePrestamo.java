package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.dto.PrestamoListDTO;
import com.sebas.demo.dto.PrestamoDTO;
import com.sebas.demo.resources.EstadoPrestamo;

public interface ServicePrestamo {
    
    List<PrestamoListDTO> findAll();

    List<PrestamoListDTO> listarPrestamosPorEstado(EstadoPrestamo estado);

    PrestamoDTO save(PrestamoDTO prestamoDTO);

    PrestamoDTO update(Long id, PrestamoDTO prestamoDTO);

    void delete(Long id);

}
