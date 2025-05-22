package org.ekujo.gesellschaft.skill.controller;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.dto.ActiveSkillDto;
import org.ekujo.gesellschaft.skill.service.ActiveSkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final ActiveSkillService activeSkillService;

    @GetMapping("/{personaId}")
    public ResponseEntity<List<ActiveSkillDto>> getActiveSkills(@PathVariable Long personaId) {
        return ResponseEntity.ok(activeSkillService.findActiveSkillsByPersonaId(personaId));
    }
}
