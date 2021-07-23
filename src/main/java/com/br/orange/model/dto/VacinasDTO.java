package com.br.orange.model.dto;

import com.br.orange.model.Usuario;
import com.br.orange.model.Vacinas;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VacinasDTO {

    @NotBlank
    @Column(name = "nomeDaVacina")
    private String nomeDaVacina;

    @NotBlank
    @Email
    @Column(name = "emailDoUsuario")
    private String emailDoUsuario;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "dataDaVacinacao")
    private LocalDate dataDaVacinacao;

    public Vacinas toEntity(Usuario user) {
        return Vacinas.builder()
                .nomeDaVacina(nomeDaVacina)
                .usuario(user)
                .dataDaVacinacao(dataDaVacinacao)
                .build();
    }

}
