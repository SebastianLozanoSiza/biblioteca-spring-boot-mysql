package com.sebas.demo.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.sebas.demo.config.LibroDTOConverter;
import com.sebas.demo.dto.LibroDTO;
import com.sebas.demo.repositories.RepositoryLibro;
import com.sebas.demo.repositories.entities.Libro;
import com.sebas.demo.services.ServiceLibro;

@Service
public class ServiceLibroImpl implements ServiceLibro{

    @Autowired
    private RepositoryLibro repositoryLibro;

    @Autowired
    private LibroDTOConverter convert;

    @Override
    @Transactional(readOnly = true)
    public List<LibroDTO> findAll() {
        List<Libro> libros = (List<Libro>) repositoryLibro.findAll();
        return libros.stream()
                .map(libro -> convert.convertLibroDTO(libro))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Libro findById(Long id) {
        return repositoryLibro.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error! Libro no existente"));
    }

    @Override
    @Transactional()
    public LibroDTO save(LibroDTO libroDTO) {
        Libro libro = convert.convertLibroEntity(libroDTO);
        libro = repositoryLibro.save(libro);
        return convert.convertLibroDTO(libro);
    }

    @Override
    @Transactional()
    public LibroDTO update(Long id, LibroDTO libroDTO) {
        Optional<Libro> libroCurrentOptional = repositoryLibro.findById(id);

        if (libroCurrentOptional.isPresent()) {
            Libro libroCurrent = libroCurrentOptional.get();
            libroCurrent.setTitulo(libroDTO.getTitulo());
            libroCurrent.setAutor(libroDTO.getAutor());
            libroCurrent.setGenero(libroDTO.getGenero());
            libroCurrent.setAñoPublicacion(libroDTO.getAñoPublicacion());
            libroCurrent.setCantidadDisponible(libroDTO.getCantidadDisponible());
            repositoryLibro.save(libroCurrent);
            return convert.convertLibroDTO(libroCurrent);
        }

        return null;
    }

    @Override
    @Transactional()
    public void delete(Long id) {
        Optional<Libro> libroOptional = repositoryLibro.findById(id);
        if (libroOptional.isPresent()) {
            repositoryLibro.delete(libroOptional.get());
        }
    }
    
}
