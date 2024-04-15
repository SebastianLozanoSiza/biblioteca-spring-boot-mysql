package com.sebas.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sebas.demo.repositories.entities.Usuario;

public interface RepositoryUsuario extends CrudRepository<Usuario,Long>{

    Optional<Usuario> findByEmail(String email);
    
}
