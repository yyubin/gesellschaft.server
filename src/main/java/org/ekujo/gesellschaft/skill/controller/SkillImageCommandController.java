package org.ekujo.gesellschaft.skill.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.dto.request.SkillImageRequest;
import org.ekujo.gesellschaft.skill.service.SkillImageCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skills/images")
@RequiredArgsConstructor
public class SkillImageCommandController {

    private final SkillImageCommandService skillImageCommandService;

    @PutMapping
    public ResponseEntity<?> updateSkillImage(@RequestBody SkillImageRequest skillImageRequest) {
        skillImageCommandService.updateSkillImageUrl(skillImageRequest);
        return ResponseEntity.ok().build();
    }

}
