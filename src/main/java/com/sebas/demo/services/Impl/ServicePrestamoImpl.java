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
public class ServicePrestamoImpl implements ServicePrestamo {

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
        // Actualizar cantidad de libros disponibles
        if (result.getEstadoPrestamo() == EstadoPrestamo.APROBADO ||
                result.getEstadoPrestamo() == EstadoPrestamo.SOLICITADO) {
            int cantidadDisponible = libro.get().getCantidadDisponible();
            if (cantidadDisponible > 0) {
                libro.get().setCantidadDisponible(cantidadDisponible - 1);
            } else {
                throw new IllegalStateException("No hay libros disponibles para prestar");
            }
        }
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
            // Si el estado cambia a CANCELADO o DEVUELTO, aumentar la cantidad de libros disponibles
            if (prestamoDTO.getEstadoPrestamo() == EstadoPrestamo.CANCELADO ||
                    prestamoDTO.getEstadoPrestamo() == EstadoPrestamo.DEVUELTO) {
                aumentarCantidadLibros(prestamoDTO.getLibroId());
            }
            return convert.converPrestamoDTO(prestamoCurrent);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Prestamo> prestamoOptional = repositoryPrestamo.findById(id);
        if (prestamoOptional.isPresent()) {
            repositoryPrestamo.delete(prestamoOptional.get());
        }
    }

    @Override
    @Transactional
    public void aumentarCantidadLibros(Long libroId) {
        Optional<Libro> libroOptional = repositoryLibro.findById(libroId);
        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get();
            libro.setCantidadDisponible(libro.getCantidadDisponible() + 1);
            repositoryLibro.save(libro);
        }
    }

}
