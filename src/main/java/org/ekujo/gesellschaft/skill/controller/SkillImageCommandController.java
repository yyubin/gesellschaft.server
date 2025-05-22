package org.ekujo.gesellschaft.skill.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.base.service.S3Service;
import org.ekujo.gesellschaft.skill.dto.request.SkillImageRequest;
import org.ekujo.gesellschaft.skill.service.SkillImageCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills/images")
@RequiredArgsConstructor
public class SkillImageCommandController {

    private final SkillImageCommandService skillImageCommandService;
    private final S3Service s3Service;

    @PutMapping
    public ResponseEntity<?> updateSkillImage(@RequestBody SkillImageRequest skillImageRequest) {
        skillImageCommandService.updateSkillImageUrl(skillImageRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/presign")
    public ResponseEntity<String> getPresignedUrl(
            @RequestParam String fileName,
            @RequestParam Long skillType,
            @RequestParam Long personaId,
            @RequestParam String characterName,
            @RequestParam String contentType
    ) {
        String url = s3Service.generatePresignedUrlforActiveSkillImages(fileName, skillType, characterName, personaId, contentType);
        return ResponseEntity.ok(url);
    }
}
