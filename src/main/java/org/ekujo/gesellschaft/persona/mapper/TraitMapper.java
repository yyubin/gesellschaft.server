package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.persona.domain.Trait;
import org.ekujo.gesellschaft.persona.dto.response.TraitResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TraitMapper {
    TraitResponse toResponse(Trait trait);
}
