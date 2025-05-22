package org.ekujo.gesellschaft.skill.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.dto.ActiveSkillDto;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillUpdateRequest;
import org.ekujo.gesellschaft.skill.service.ActiveSkillCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/skills")
public class SkillCommandController {
    private final ActiveSkillCommandService activeSkillCommandService;

    @PostMapping("/{id}")
    public ResponseEntity<ActiveSkillDto> createActiveSkill(@RequestBody ActiveSkillCreateRequest request, @PathVariable String id) {
        return ResponseEntity.ok(activeSkillCommandService.createActiveSkill(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActiveSkillDto> updateActiveSkill(@RequestBody ActiveSkillUpdateRequest request) {
        return ResponseEntity.ok(activeSkillCommandService.updateActiveSkill(request));
    }

}
