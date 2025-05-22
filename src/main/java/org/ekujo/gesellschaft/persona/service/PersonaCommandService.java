package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.request.PersonaCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.PersonaUpdateRequest;

public interface PersonaCommandService {
    PersonaDetailDto updatePersona(PersonaUpdateRequest personaUpdateRequest);
    PersonaDetailDto createPersona(PersonaCreateRequest req);
}
