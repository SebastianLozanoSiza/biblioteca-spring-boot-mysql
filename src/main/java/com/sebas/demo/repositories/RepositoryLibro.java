package com.sebas.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sebas.demo.repositories.entities.Libro;

public interface RepositoryLibro extends CrudRepository<Libro,Long>{
    
}
