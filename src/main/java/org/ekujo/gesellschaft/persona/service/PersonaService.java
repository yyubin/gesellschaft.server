package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.PersonaSummaryDto;

import java.util.List;

public interface PersonaService {
    PersonaDetailDto getPersonaDetail(Long id);
    List<PersonaDetailDto> getPersonaDetailsByCharacterId(Long characterId);
    List<PersonaSummaryDto> getAllPersonaDetails(int page, int size);
}
