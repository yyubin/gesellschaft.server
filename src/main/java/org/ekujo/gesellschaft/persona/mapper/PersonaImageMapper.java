package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.persona.domain.PersonaImage;
import org.ekujo.gesellschaft.persona.dto.response.PersonaImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonaMapper.class, CharacterMapper.class})
public interface PersonaImageMapper {

    @Mapping(source = "persona", target = "persona")
    @Mapping(source = "persona.character", target = "character")
    PersonaImageResponse toResponse(PersonaImage image);
}
