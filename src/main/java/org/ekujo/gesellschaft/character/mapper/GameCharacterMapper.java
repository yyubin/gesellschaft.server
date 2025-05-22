package org.ekujo.gesellschaft.character.mapper;

import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.ekujo.gesellschaft.character.dto.GameCharacterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameCharacterMapper {
    GameCharacterDto toDto(GameCharacter gameCharacter);
}
