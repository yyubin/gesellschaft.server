package org.ekujo.gesellschaft.skill.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.ekujo.gesellschaft.skill.dto.response.SkillImageResponse;
import org.ekujo.gesellschaft.skill.mapper.ActiveSkillMapper;
import org.ekujo.gesellschaft.skill.service.SkillImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SkillImageServiceImpl implements SkillImageService {

    private final ActiveSkillMapper activeSkillMapper;
    private final PersonaService personaService;

    public List<SkillImageResponse> findSkillImagesByPersonaId(Long personaId) {
        Persona personaById = personaService.getPersonaById(personaId);
        return personaById.getActiveSkills().stream()
                .map(activeSkillMapper::toSkillImageResponse)
                .collect(Collectors.toList());
    }

}
