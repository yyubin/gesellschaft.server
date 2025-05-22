package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.request.PersonaCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.PersonaUpdateRequest;
import org.ekujo.gesellschaft.persona.service.PersonaCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonaCommandController {

    private final PersonaCommandService personaCommandService;

    @PutMapping
    public ResponseEntity<PersonaDetailDto> updatePersona(@RequestBody PersonaUpdateRequest personaUpdateRequest) {
        return ResponseEntity.ok(personaCommandService.updatePersona(personaUpdateRequest));
    }

    @PostMapping
    public ResponseEntity<PersonaDetailDto> createPersona(@RequestBody PersonaCreateRequest personaCreateRequest) {
        return ResponseEntity.ok(personaCommandService.createPersona(personaCreateRequest));
    }

}
