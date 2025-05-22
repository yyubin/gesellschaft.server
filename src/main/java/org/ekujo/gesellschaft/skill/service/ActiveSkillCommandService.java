package org.ekujo.gesellschaft.skill.service;

import org.ekujo.gesellschaft.skill.dto.ActiveSkillDto;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillUpdateRequest;

public interface ActiveSkillCommandService {
    ActiveSkillDto createActiveSkill(ActiveSkillCreateRequest activeSkillCreateRequest);
    ActiveSkillDto updateActiveSkill(ActiveSkillUpdateRequest request);
}
