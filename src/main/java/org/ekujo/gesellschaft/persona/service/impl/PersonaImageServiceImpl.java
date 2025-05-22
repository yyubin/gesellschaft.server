package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.domain.PersonaImage;
import org.ekujo.gesellschaft.persona.dto.response.PersonaImageResponse;
import org.ekujo.gesellschaft.persona.mapper.PersonaImageMapper;
import org.ekujo.gesellschaft.persona.respository.PersonaImageRepository;
import org.ekujo.gesellschaft.persona.service.PersonaImageCommandService;
import org.ekujo.gesellschaft.persona.service.PersonaImageService;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonaImageServiceImpl implements PersonaImageService {

    private final PersonaImageMapper personaImageMapper;
    private final PersonaService personaService;
    private final PersonaImageCommandService personaImageCommandService;

    @Transactional
    public PersonaImageResponse getPersonaImageById(Long id) {
        Persona personaById = personaService.getPersonaById(id);
        if (personaById.getPersonaImage() == null) {
            personaImageCommandService.createNewPersonaImage(personaById);
        }
        return personaImageMapper.toResponse(personaById.getPersonaImage());
    }

}
