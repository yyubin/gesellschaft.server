package org.ekujo.gesellschaft.skill.service;

import org.ekujo.gesellschaft.skill.dto.request.SkillImageRequest;

public interface SkillImageCommandService {
    void updateSkillImageUrl(SkillImageRequest skillImageRequest);
}
