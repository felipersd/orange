package com.br.orange.service;

import com.br.orange.model.Usuario;
import com.br.orange.model.dto.UsuarioDTO;
import com.br.orange.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario findUsuarioById(Long id){
        try {
            return usuarioRepository.findUsuarioById(id);
        }
        catch(Exception e){
            throw e;
        }
    }

    public Usuario addUsuario(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        }
        catch(Exception e){
            throw e;
        }
    }

    public Usuario atualizaUsuario(UsuarioDTO usuarioDto, Long id){
        try{
            Usuario user = usuarioRepository.findUsuarioById(id);
            return usuarioRepository.save(usuarioDto.toEntity(user));
        }
        catch (Exception e){
            throw e;
        }
    }

}
