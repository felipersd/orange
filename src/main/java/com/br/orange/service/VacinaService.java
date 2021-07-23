package com.br.orange.service;

import com.br.orange.model.Usuario;
import com.br.orange.model.Vacinas;
import com.br.orange.model.dto.VacinasDTO;
import com.br.orange.repository.UsuarioRepository;
import com.br.orange.repository.VacinasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final UsuarioRepository usuarioRepository;
    private final VacinasRepository vacinasRepository;

    public Vacinas addVacina(VacinasDTO vacinaDTO) {
        try {
            return vacinasRepository.save(vacinaDTO.toEntity(usuarioRepository.findUsuarioByEmail(vacinaDTO.getEmailDoUsuario())));
        }
        catch(Exception e){
            throw e;
        }
    }

}
