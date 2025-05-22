package org.ekujo.gesellschaft.persona.mapper;

import org.ekujo.gesellschaft.persona.domain.Keyword;
import org.ekujo.gesellschaft.persona.dto.response.KeywordResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeywordMapper {
    KeywordResponse toKeywordResponse(Keyword keyword);
}
