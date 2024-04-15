package com.sebas.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sebas.demo.dto.UsuarioListDTO;
import com.sebas.demo.dto.UsuarioDTO;
import com.sebas.demo.repositories.entities.Usuario;

@Component
public class UsuarioDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    @Autowired
    public UsuarioDTOConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;
    }

    public UsuarioListDTO convertUsuarioListDTO(Usuario usuario){
        UsuarioListDTO usuarioListDTO = dbm.map(usuario, UsuarioListDTO.class);
        usuarioListDTO.setNombre(usuario.getNombre() + " " + usuario.getApellido());
        return usuarioListDTO;
    }

    public Usuario convertUsuarioEntity(UsuarioListDTO usuarioListDTO){
        return dbm.map(usuarioListDTO, Usuario.class);   
    }

    public UsuarioDTO convertUsuarioDTO(Usuario usuario){
        UsuarioDTO usuarioSaveDTO = dbm.map(usuario, UsuarioDTO.class);
        return usuarioSaveDTO;
    }

    public Usuario convertUsuarioEntity(UsuarioDTO usuarioDTO){
        return dbm.map(usuarioDTO, Usuario.class);   
    }
}
