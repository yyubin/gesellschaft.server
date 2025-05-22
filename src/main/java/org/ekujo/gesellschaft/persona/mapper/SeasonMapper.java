package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.persona.domain.Season;
import org.ekujo.gesellschaft.persona.dto.SeasonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    SeasonDto toDto(Season season);
}
