package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<TraitResponse> update(@RequestBody Long id, @RequestBody String traitName) {
        TraitResponse traitResponse = traitService.updateTrait(id, traitName);
        return ResponseEntity.ok(traitResponse);
    }

    @PostMapping
    public ResponseEntity<TraitResponse> add(String traitName) {
        TraitResponse traitResponse = traitService.createTrait(traitName);
        return ResponseEntity.ok(traitResponse);
    }


}
