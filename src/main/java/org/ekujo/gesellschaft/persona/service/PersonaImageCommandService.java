package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.request.PersonaImageRequest;

public interface PersonaImageCommandService {
    void save(PersonaImageRequest personaImageRequest);
}
