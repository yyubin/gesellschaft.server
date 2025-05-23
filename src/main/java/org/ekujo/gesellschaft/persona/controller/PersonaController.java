package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.base.dto.PageResultDto;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.PersonaSummaryDto;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/characters/{id}")
    public ResponseEntity<List<PersonaDetailDto>> getPersonaCharacter(@PathVariable Long id) {
        List<PersonaDetailDto> personaDetailDtoList = personaService.getPersonaDetailsByCharacterId(id);
        return ResponseEntity.ok(personaDetailDtoList);
    }

    @GetMapping
    public ResponseEntity<PageResultDto<PersonaSummaryDto>> getPersonas(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long characterId
    ) {
        PageResultDto<PersonaSummaryDto> personaSummaryDtoList = personaService.getAllPersonaDetails(page, size, sortBy, name, characterId);
        return ResponseEntity.ok(personaSummaryDtoList);
    }

}
