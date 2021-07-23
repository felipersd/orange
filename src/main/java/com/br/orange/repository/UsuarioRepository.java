package com.br.orange.repository;

import com.br.orange.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findUsuarioByEmail(String Email);

    Usuario findUsuarioById(Long id);
}
