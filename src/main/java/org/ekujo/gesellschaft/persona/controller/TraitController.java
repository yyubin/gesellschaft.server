package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.request.TraitCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.TraitUpdateRequest;
import org.ekujo.gesellschaft.persona.dto.response.KeywordResponse;
import org.ekujo.gesellschaft.persona.dto.response.TraitResponse;
import org.ekujo.gesellschaft.persona.service.KeywordService;
import org.ekujo.gesellschaft.persona.service.TraitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traits")
@RequiredArgsConstructor
public class TraitController {

    private final TraitService traitService;

    @GetMapping
    public ResponseEntity<List<TraitResponse>> getAll() {
        return ResponseEntity.ok(traitService.findAll());
    }

    @PutMapping
    public ResponseEntity<TraitResponse> update(@RequestBody TraitUpdateRequest traitUpdateRequest) {
        TraitResponse traitResponse = traitService.updateTrait(traitUpdateRequest.getId(), traitUpdateRequest.getTraitName());
        return ResponseEntity.ok(traitResponse);
    }

    @PostMapping
    public ResponseEntity<TraitResponse> add(@RequestBody TraitCreateRequest traitCreateRequest) {
        TraitResponse traitResponse = traitService.createTrait(traitCreateRequest.getTraitName());
        return ResponseEntity.ok(traitResponse);
    }


}
