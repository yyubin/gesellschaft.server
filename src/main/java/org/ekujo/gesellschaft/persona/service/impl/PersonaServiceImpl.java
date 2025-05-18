package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.exception.PersonaErrorCode;
import org.ekujo.gesellschaft.persona.exception.PersonaException;
import org.ekujo.gesellschaft.persona.mapper.PersonaMapper;
import org.ekujo.gesellschaft.persona.respository.PersonaRepository;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    public PersonaDetailDto getPersonaDetail(Long id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new PersonaException(PersonaErrorCode.PERSONA_NOT_FOUND));
        return personaMapper.toDto(persona);
    }
}
