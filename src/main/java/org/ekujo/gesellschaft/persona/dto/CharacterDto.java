package org.ekujo.gesellschaft.persona.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CharacterDto {
    private Integer id;
    private String name;
    private String nameKo;
}