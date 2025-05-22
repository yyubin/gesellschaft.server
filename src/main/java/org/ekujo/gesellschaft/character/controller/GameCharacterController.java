package org.ekujo.gesellschaft.character.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.character.dto.GameCharacterDto;
import org.ekujo.gesellschaft.character.service.GameCharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class GameCharacterController {
    private final GameCharacterService gameCharacterService;

    @GetMapping
    public ResponseEntity<List<GameCharacterDto>> findAll() {
        return ResponseEntity.ok(gameCharacterService.findAll());
    }
}
