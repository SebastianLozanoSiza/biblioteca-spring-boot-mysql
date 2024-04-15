package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.dto.LibroDTO;
import com.sebas.demo.repositories.entities.Libro;

public interface ServiceLibro {
    
    List<LibroDTO> findAll();

    Libro findById(Long id);

    LibroDTO save(LibroDTO libroDTO);

    LibroDTO update(Long id, LibroDTO libroDTO);

    void delete(Long id);
}
