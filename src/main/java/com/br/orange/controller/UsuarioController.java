package com.br.orange.controller;

import com.br.orange.model.Usuario;
import com.br.orange.model.dto.UsuarioDTO;
import com.br.orange.repository.UsuarioRepository;
import com.br.orange.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity getAllUsuario(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.findUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity salvaUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.addUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaUsuario(@Valid @RequestBody UsuarioDTO usuarioDto, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.atualizaUsuario(usuarioDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id){
        usuarioRepository.deleteById(id);
    }
}
