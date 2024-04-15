package com.sebas.demo.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.sebas.demo.config.UsuarioDTOConverter;
import com.sebas.demo.dto.UsuarioListDTO;
import com.sebas.demo.dto.UsuarioDTO;
import com.sebas.demo.repositories.RepositoryUsuario;
import com.sebas.demo.repositories.entities.Usuario;
import com.sebas.demo.services.ServiceUsuario;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceUsuarioImpl implements ServiceUsuario {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private UsuarioDTOConverter convert;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioListDTO> findAll() {
        List<Usuario> usuarios = (List<Usuario>) repositoryUsuario.findAll();
        return usuarios.stream()
                .map(usuario -> convert.convertUsuarioListDTO(usuario))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return repositoryUsuario.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                        "Error! Usuario no existente"));
    }

    @Override
    @Transactional()
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = convert.convertUsuarioEntity(usuarioDTO);
        usuario = repositoryUsuario.save(usuario);
        return convert.convertUsuarioDTO(usuario);
    }

    @Override
    @Transactional()
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioCurrentOptional = repositoryUsuario.findById(id);
        if (usuarioCurrentOptional.isPresent()) {
            Usuario usuarioCurrent = usuarioCurrentOptional.get();
            usuarioCurrent.setCedula(usuarioDTO.getCedula());
            usuarioCurrent.setNombre(usuarioDTO.getNombre());
            usuarioCurrent.setApellido(usuarioDTO.getApellido());
            usuarioCurrent.setEmail(usuarioDTO.getEmail());
            usuarioCurrent.setPassword(usuarioDTO.getPassword());
            repositoryUsuario.save(usuarioCurrent);
            return convert.convertUsuarioDTO(usuarioCurrent);
            
        }
        return null;
    }

    @Override
    @Transactional()
    public void delete(Long id) {
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(id);
        if (usuarioOptional.isPresent()) {
            repositoryUsuario.delete(usuarioOptional.get());
        }
    }

}
