package com.sebas.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sebas.demo.repositories.entities.Prestamo;
import com.sebas.demo.resources.EstadoPrestamo;

public interface RepositoryPrestamo extends CrudRepository<Prestamo,Long>{
    
    List<Prestamo> findByEstadoPrestamo(EstadoPrestamo estado);
}
