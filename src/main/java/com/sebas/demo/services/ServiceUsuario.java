package com.sebas.demo.services;

import java.util.List;

import com.sebas.demo.dto.UsuarioListDTO;
import com.sebas.demo.dto.UsuarioDTO;
import com.sebas.demo.repositories.entities.Usuario;

public interface ServiceUsuario {
    
    List<UsuarioListDTO> findAll();

    Usuario findById(Long id);

    UsuarioDTO save(UsuarioDTO usuarioDTO);

    UsuarioDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);
}
