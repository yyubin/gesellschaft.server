package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;

import java.util.List;

public interface PersonaService {
    PersonaDetailDto getPersonaDetail(Long id);
    List<PersonaDetailDto> getPersonaDetailsByCharacterId(Long characterId);
    List<PersonaDetailDto> getAllPersonaDetails(int page, int size);
}
