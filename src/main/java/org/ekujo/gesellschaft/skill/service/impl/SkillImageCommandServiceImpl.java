package org.ekujo.gesellschaft.skill.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.dto.request.SkillImageRequest;
import org.ekujo.gesellschaft.skill.service.ActiveSkillService;
import org.ekujo.gesellschaft.skill.service.SkillImageCommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SkillImageCommandServiceImpl implements SkillImageCommandService {

    private final ActiveSkillService activeSkillService;

    public void updateSkillImageUrl(SkillImageRequest skillImageRequest) {
        ActiveSkill activeSkillById = activeSkillService.findActiveSkillById(skillImageRequest.getId());
        activeSkillById.setSkillImage(skillImageRequest.getUrl());
    }

}
