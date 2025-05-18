package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/personas")
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDetailDto> getPersona(@PathVariable Long id) {
        PersonaDetailDto personaDetail = personaService.getPersonaDetail(id);
        return ResponseEntity.ok(personaDetail);
    }
}
