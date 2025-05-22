package org.ekujo.gesellschaft.persona.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.ekujo.gesellschaft.persona.domain.Keyword;
import org.ekujo.gesellschaft.persona.dto.response.KeywordResponse;
import org.ekujo.gesellschaft.persona.service.KeywordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keywords")
@RequiredArgsConstructor
public class KeywordController {

    private final KeywordService keywordService;

    @GetMapping
    public ResponseEntity<List<KeywordResponse>> getAll() {
        return ResponseEntity.ok(keywordService.findAll());
    }

    @PutMapping
    public ResponseEntity<KeywordResponse> update(@RequestBody Long id, @RequestBody String keywordName) {
        KeywordResponse keywordResponse = keywordService.updateKeyword(id, keywordName);
        return ResponseEntity.ok(keywordResponse);
    }

    @PostMapping
    public ResponseEntity<KeywordResponse> add(String keywordName) {
        KeywordResponse keyword = keywordService.createKeyword(keywordName);
        return ResponseEntity.ok(keyword);
    }

}
