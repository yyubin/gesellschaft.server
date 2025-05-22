package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.base.dto.PageResultDto;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.PersonaSummaryDto;

import java.util.List;

public interface PersonaService {
    Persona getPersonaById(Long id);
    PersonaDetailDto getPersonaDetail(Long id);
    List<PersonaDetailDto> getPersonaDetailsByCharacterId(Long characterId);
    PageResultDto<PersonaSummaryDto> getAllPersonaDetails(int page, int size);
}
