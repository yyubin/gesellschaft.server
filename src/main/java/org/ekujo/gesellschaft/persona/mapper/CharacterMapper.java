package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.ekujo.gesellschaft.persona.dto.CharacterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDto toDto(GameCharacter character);
}