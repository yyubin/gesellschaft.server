package org.ekujo.gesellschaft.skill.service;

import org.ekujo.gesellschaft.skill.domain.ActiveSkill;

public interface ActiveSkillService {
    ActiveSkill findActiveSkillById(Long id);
}
