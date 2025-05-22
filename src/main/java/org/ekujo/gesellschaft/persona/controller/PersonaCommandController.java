package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.request.PersonaUpdateRequest;
import org.ekujo.gesellschaft.persona.service.PersonaCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonaCommandController {

    private final PersonaCommandService personaCommandService;

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDetailDto> updatePersona(@PathVariable Long id, @RequestBody PersonaUpdateRequest personaUpdateRequest) {
        return ResponseEntity.ok(personaCommandService.updatePersona(personaUpdateRequest));
    }

}
