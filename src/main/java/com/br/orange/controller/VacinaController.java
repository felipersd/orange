package com.br.orange.controller;


import com.br.orange.model.dto.VacinasDTO;
import com.br.orange.repository.VacinasRepository;
import com.br.orange.service.VacinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/vacina")
@RequiredArgsConstructor
public class VacinaController {

    private final VacinasRepository vacinasRepository;
    private final VacinaService vacinaService;

    @GetMapping()
    public ResponseEntity getVacina(){
        return ResponseEntity.ok(vacinasRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity salvaVacina(@Valid @RequestBody VacinasDTO vacinas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaService.addVacina(vacinas));
    }

}
