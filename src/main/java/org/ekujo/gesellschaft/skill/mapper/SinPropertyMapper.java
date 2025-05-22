package org.ekujo.gesellschaft.skill.mapper;

import org.ekujo.gesellschaft.skill.domain.SinProperty;
import org.ekujo.gesellschaft.skill.dto.response.SinPropertyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SinPropertyMapper {
    SinPropertyResponse toResponse(SinProperty sin);
}
