package com.br.orange.model.dto;

import com.br.orange.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Optional;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private String nome;

    @Email
    private String email;

    @Size(min = 11, max = 11)
    @CPF
    private String cpf;

    private String dataDeNascimento;

    public Usuario toEntity(Usuario user){
        return Usuario.builder()
                .id(user.getId())
                .nome(this.nome != null ? this.nome : user.getNome())
                .email(this.email != null ? this.email : user.getEmail())
                .cpf(this.cpf != null ? this.cpf : user.getCpf())
                .dataDeNascimento(this.dataDeNascimento != null ? this.dataDeNascimento : user.getDataDeNascimento())
                .build();
    }

}
