package com.sebas.demo.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.demo.config.PrestamoDTOConverter;
import com.sebas.demo.dto.PrestamoListDTO;
import com.sebas.demo.dto.PrestamoDTO;
import com.sebas.demo.repositories.RepositoryLibro;
import com.sebas.demo.repositories.RepositoryPrestamo;
import com.sebas.demo.repositories.RepositoryUsuario;
import com.sebas.demo.repositories.entities.Libro;
import com.sebas.demo.repositories.entities.Prestamo;
import com.sebas.demo.repositories.entities.Usuario;
import com.sebas.demo.resources.EstadoPrestamo;
import com.sebas.demo.services.ServicePrestamo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicePrestamoImpl implements ServicePrestamo{
    
    @Autowired
    private RepositoryPrestamo repositoryPrestamo;
    private RepositoryUsuario repositoryUsuario;
    private RepositoryLibro repositoryLibro;

    @Autowired
    private PrestamoDTOConverter convert;
    
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoListDTO> findAll() {
        List<Prestamo> prestamos = (List<Prestamo>) repositoryPrestamo.findAll();
        return prestamos.stream()
                    .map(prestamo -> convert.convertPrestamoListDTO(prestamo))
                    .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoListDTO> listarPrestamosPorEstado(EstadoPrestamo estado) {
        List<Prestamo> prestamos = repositoryPrestamo.findByEstadoPrestamo(estado);
        return prestamos.stream()
                    .map(prestamo -> convert.convertPrestamoListDTO(prestamo))
                    .toList();
    }

    @Override
    @Transactional
    public PrestamoDTO save(PrestamoDTO prestamoDTO) {
        Optional<Usuario> usuario = repositoryUsuario.findById(prestamoDTO.getUsuarioId());
        Optional<Libro> libro = repositoryLibro.findById(prestamoDTO.getLibroId());
        Prestamo result = convert.convertPrestamoEntity(prestamoDTO);
        if (!usuario.isPresent()) {
            System.out.println("Error, usuario no existente");
        }
        if (!libro.isPresent()) {
            System.out.println("Error, libro no existente");
        }
        result.setUsuario(usuario.get());
        result.setLibro(libro.get());
        return convert.converPrestamoDTO(repositoryPrestamo.save(result));
    }

    @Override
    @Transactional
    public PrestamoDTO update(Long id, PrestamoDTO prestamoDTO) {
        Optional<Usuario> usuarOptional = repositoryUsuario.findById(prestamoDTO.getUsuarioId());
        Optional<Libro> libroOptional = repositoryLibro.findById(prestamoDTO.getLibroId());
        Optional<Prestamo> prestamoCurrentOptional = repositoryPrestamo.findById(id);

        if (usuarOptional.isPresent() && libroOptional.isPresent() && prestamoCurrentOptional.isPresent()) {
            Prestamo prestamoCurrent = prestamoCurrentOptional.get();
            prestamoCurrent.setUsuario(usuarOptional.get());
            prestamoCurrent.setLibro(libroOptional.get());
            prestamoCurrent.setEstadoPrestamo(prestamoDTO.getEstadoPrestamo());
            repositoryPrestamo.save(prestamoCurrent);
            return convert.converPrestamoDTO(prestamoCurrent);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
