package org.ekujo.gesellschaft.skill.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ekujo.gesellschaft.persona.dto.PersonaDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillImageResponse {
    private Long id;
    private PersonaDto persona;
    private String skillName;
    private String skillIndex;
    private String skillImage;
}
