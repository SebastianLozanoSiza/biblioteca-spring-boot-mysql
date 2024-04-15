package com.sebas.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sebas.demo.dto.LibroDTO;
import com.sebas.demo.repositories.entities.Libro;

@Component
public class LibroDTOConverter {

    @Autowired
    private ModelMapper dbm;

    @Autowired
    public LibroDTOConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;
    }

    public LibroDTO convertLibroDTO(Libro libro){
        LibroDTO libroDTO = dbm.map(libro, LibroDTO.class);
        return libroDTO;
    }

    public Libro convertLibroEntity(LibroDTO libroDTO){
        return dbm.map(libroDTO, Libro.class);   
    }
    
}
