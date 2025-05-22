package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.PersonaDto;
import org.ekujo.gesellschaft.persona.dto.PersonaSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDetailDto toDto(Persona entity);
    @Mapping(source = "character", target = "characterName")
    PersonaSummaryDto toSummaryDto(Persona entity);
    PersonaDto toPersonaDto(Persona persona);
}
