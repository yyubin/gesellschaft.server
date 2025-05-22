package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.domain.PersonaImage;
import org.ekujo.gesellschaft.persona.dto.request.PersonaImageRequest;
import org.ekujo.gesellschaft.persona.respository.PersonaImageRepository;
import org.ekujo.gesellschaft.persona.service.PersonaImageCommandService;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonaImageCommandServiceImpl implements PersonaImageCommandService {

    private final PersonaImageRepository personaImageRepository;
    private final PersonaService personaService;

    public void save(PersonaImageRequest personaImageRequest) {
        Persona personaById = personaService.getPersonaById(personaImageRequest.getPersonaId());
        personaById.updatePersonaImage(personaImageRequest);
    }

    public void createNewPersonaImage(Persona persona) {
        if (persona.getPersonaImage() != null) return;

        PersonaImage newImage = new PersonaImage();
        newImage.setPersona(persona);
        persona.setPersonaImage(newImage);
        personaImageRepository.save(newImage);
    }

}
