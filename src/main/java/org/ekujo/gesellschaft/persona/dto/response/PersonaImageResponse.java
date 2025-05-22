package org.ekujo.gesellschaft.persona.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.CharacterDto;
import org.ekujo.gesellschaft.persona.dto.PersonaDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaImageResponse {

    private Long id;
    private PersonaDto persona;
    private CharacterDto character;
    private String imageA;
    private String imageAc;
    private String imageSd;

}
