package org.ekujo.gesellschaft.skill.service;

import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.dto.ActiveSkillDto;

import java.util.List;

public interface ActiveSkillService {
    ActiveSkill findActiveSkillById(Long id);
    List<ActiveSkillDto> findActiveSkillsByPersonaId(Long personaId);
}
