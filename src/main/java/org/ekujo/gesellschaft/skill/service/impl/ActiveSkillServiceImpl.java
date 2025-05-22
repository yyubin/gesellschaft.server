package org.ekujo.gesellschaft.skill.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.repository.ActiveSkillRepository;
import org.ekujo.gesellschaft.skill.service.ActiveSkillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ActiveSkillServiceImpl implements ActiveSkillService {

    private final ActiveSkillRepository activeSkillRepository;

    public ActiveSkill findActiveSkillById(Long id) {
        return activeSkillRepository.findById(id).orElse(null);
    }

}
