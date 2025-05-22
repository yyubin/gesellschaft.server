package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.domain.PersonaTrait;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.PersonaDto;
import org.ekujo.gesellschaft.persona.dto.PersonaSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    @Mapping(target = "traits", expression = "java(mapTraits(entity.getTraits()))")
    PersonaDetailDto toDto(Persona entity);

    default List<PersonaDetailDto.TraitDto> mapTraits(List<PersonaTrait> personaTraits) {
        return personaTraits.stream()
                .map(pt -> PersonaDetailDto.TraitDto.builder()
                        .id(pt.getTrait().getId())
                        .name(pt.getTrait().getName())
                        .build())
                .toList();
    }

    @Mapping(source = "character", target = "characterName")
    PersonaSummaryDto toSummaryDto(Persona entity);
    PersonaDto toPersonaDto(Persona persona);
}
