package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.response.PersonaImageResponse;
import org.ekujo.gesellschaft.persona.service.PersonaImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas/images")
@RequiredArgsConstructor
public class PersonaImageController {

    private final PersonaImageService personaImageService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonaImageResponse> getPersonaImage(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personaImageService.getPersonaImageById(id));
    }

}
