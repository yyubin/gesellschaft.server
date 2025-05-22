package org.ekujo.gesellschaft.skill.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.dto.ActiveSkillDto;
import org.ekujo.gesellschaft.skill.dto.response.SkillImageResponse;
import org.ekujo.gesellschaft.skill.mapper.ActiveSkillMapper;
import org.ekujo.gesellschaft.skill.repository.ActiveSkillRepository;
import org.ekujo.gesellschaft.skill.service.ActiveSkillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ActiveSkillServiceImpl implements ActiveSkillService {

    private final ActiveSkillRepository activeSkillRepository;
    private final PersonaService personaService;
    private final ActiveSkillMapper activeSkillMapper;

    public ActiveSkill findActiveSkillById(Long id) {
        return activeSkillRepository.findById(id).orElse(null);
    }

    public List<ActiveSkillDto> findActiveSkillsByPersonaId(Long personaId) {
        Persona personaById = personaService.getPersonaById(personaId);
        return personaById.getActiveSkills().stream().map(activeSkillMapper::toActiveSkillDto).collect(Collectors.toList());
    }

}
