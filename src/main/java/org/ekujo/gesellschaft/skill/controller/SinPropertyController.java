package org.ekujo.gesellschaft.skill.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.dto.request.SinPropertyCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.SinPropertyUpdateRequest;
import org.ekujo.gesellschaft.skill.dto.response.SinPropertyResponse;
import org.ekujo.gesellschaft.skill.service.SinPropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sin-property")
@RequiredArgsConstructor
public class SinPropertyController {

    private final SinPropertyService sinPropertyService;

    @GetMapping
    public ResponseEntity<List<SinPropertyResponse>> getAllSinProperty() {
        return ResponseEntity.ok(sinPropertyService.findAll());
    }

    @PutMapping
    public ResponseEntity<SinPropertyResponse> updateSinProperty(@RequestBody SinPropertyUpdateRequest request) {
        return ResponseEntity.ok(sinPropertyService.updateSinProperty(request));
    }

    @PostMapping
    public ResponseEntity<SinPropertyResponse> createSinProperty(@RequestBody SinPropertyCreateRequest request) {
        return ResponseEntity.ok(sinPropertyService.createSinProperty(request));
    }
}
