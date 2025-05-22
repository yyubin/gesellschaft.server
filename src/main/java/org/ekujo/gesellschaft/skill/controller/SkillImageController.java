package org.ekujo.gesellschaft.skill.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.dto.response.SkillImageResponse;
import org.ekujo.gesellschaft.skill.service.SkillImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills/images")
@RequiredArgsConstructor
public class SkillImageController {

    private final SkillImageService skillImageService;

    @GetMapping("/{personaId}")
    public ResponseEntity<List<SkillImageResponse>> getSkillImages(@PathVariable Long personaId) {
        List<SkillImageResponse> skillImagesByPersonaId = skillImageService.findSkillImagesByPersonaId(personaId);
        return ResponseEntity.ok(skillImagesByPersonaId);
    }
}
