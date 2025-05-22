package org.ekujo.gesellschaft.skill.service;

import org.ekujo.gesellschaft.skill.dto.response.SkillImageResponse;

import java.util.List;

public interface SkillImageService {
    List<SkillImageResponse> findSkillImagesByPersonaId(Long personaId);
}
