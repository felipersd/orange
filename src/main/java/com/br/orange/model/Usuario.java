package com.br.orange.model;

import com.br.orange.model.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="TB_USUARIO", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email", name = "email_uk"),
    @UniqueConstraint(columnNames = "cpf", name = "cpf_uk")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotBlank()
    @Column(name = "nome")
    private String nome;

    @NotBlank()
    @Email
    @Setter
    @Column(name = "email")
    private String email;

    @NotBlank()
    @Size(min = 11, max = 11)
    @CPF
    @Column(name = "cpf")
    private String cpf;

    @NotNull
    @Column(name = "dataDeNascimento")
    private String dataDeNascimento;
}
