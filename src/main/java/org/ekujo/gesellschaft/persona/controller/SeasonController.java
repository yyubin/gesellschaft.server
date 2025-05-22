package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.SeasonDto;
import org.ekujo.gesellschaft.persona.dto.request.SeasonCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.SeasonUpdateRequest;
import org.ekujo.gesellschaft.persona.service.SeasonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seasons")
@RequiredArgsConstructor
public class SeasonController {
    private final SeasonService seasonService;

    @GetMapping
    public ResponseEntity<List<SeasonDto>> getAllSeasons() {
        return ResponseEntity.ok(seasonService.findAll());
    }

    @PostMapping
    public ResponseEntity<SeasonDto> createSeason(@RequestBody SeasonCreateRequest seasonCreateRequest) {
        return ResponseEntity.ok(seasonService.create(seasonCreateRequest));
    }

    @PutMapping
    public ResponseEntity<SeasonDto> updateSeason(@RequestBody SeasonUpdateRequest seasonUpdateRequest) {
        return ResponseEntity.ok(seasonService.update(seasonUpdateRequest));
    }
}

