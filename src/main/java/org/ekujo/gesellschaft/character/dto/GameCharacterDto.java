package org.ekujo.gesellschaft.character.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCharacterDto {
    private Long id;
    private String name;
    private String nameKo;
}
