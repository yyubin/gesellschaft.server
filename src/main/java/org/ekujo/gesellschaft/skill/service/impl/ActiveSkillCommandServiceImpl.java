package org.ekujo.gesellschaft.skill.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.domain.SinProperty;
import org.ekujo.gesellschaft.skill.dto.ActiveSkillDto;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillUpdateRequest;
import org.ekujo.gesellschaft.skill.mapper.ActiveSkillMapper;
import org.ekujo.gesellschaft.skill.repository.ActiveSkillRepository;
import org.ekujo.gesellschaft.skill.service.ActiveSkillCommandService;
import org.ekujo.gesellschaft.skill.service.ActiveSkillService;
import org.ekujo.gesellschaft.skill.service.SinPropertyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class ActiveSkillCommandServiceImpl implements ActiveSkillCommandService {

    private final PersonaService personaService;
    private final SinPropertyService sinPropertyService;
    private final ActiveSkillMapper activeSkillMapper;
    private final ActiveSkillRepository activeSkillRepository;

    public ActiveSkillDto createActiveSkill(ActiveSkillCreateRequest activeSkillCreateRequest) {
        Persona personaById = personaService.getPersonaById(activeSkillCreateRequest.getPersonaId());
        SinProperty sinProperty = sinPropertyService.findById(activeSkillCreateRequest.getSinPropertyId());
        ActiveSkill activeSkill = personaById.addActiveSkill(activeSkillCreateRequest, sinProperty);
        return activeSkillMapper.toActiveSkillDto(activeSkill);
    }

    public ActiveSkillDto updateActiveSkill(ActiveSkillUpdateRequest request) {
        ActiveSkill skill = activeSkillRepository.findById(request.getId())
                .orElseThrow(() -> new NoSuchElementException("ActiveSkill not found"));

        SinProperty sinProperty = sinPropertyService.findById(request.getSinPropertyId());
        skill.update(request, sinProperty);
        return activeSkillMapper.toActiveSkillDto(skill);
    }
}
