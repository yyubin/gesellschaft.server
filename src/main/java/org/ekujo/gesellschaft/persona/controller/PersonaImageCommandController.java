package org.ekujo.gesellschaft.persona.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.request.PersonaImageRequest;
import org.ekujo.gesellschaft.persona.service.PersonaImageCommandService;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.ekujo.gesellschaft.persona.service.S3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/personas/images")
public class PersonaImageCommandController {

    private final S3Service s3Service;
    private final PersonaImageCommandService personaImageCommandService;


    @PostMapping("/presign")
    public ResponseEntity<String> getPresignedUrl(
            @RequestParam String fileName,
            @RequestParam String type
    ) {
        String url = s3Service.generatePresignedUrl(fileName, type);
        return ResponseEntity.ok(url);
    }

    @PostMapping
    public ResponseEntity<Void> saveImageInfo(@RequestBody PersonaImageRequest dto) {
        personaImageCommandService.save(dto);
        return ResponseEntity.ok().build();
    }
}
