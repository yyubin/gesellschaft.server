package org.ekujo.gesellschaft.persona.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PersonaSearchRequestDto {
    private List<String> characterIds;
    private List<String> sinIds;
    private List<String> keywordIds;
    private List<String> attackTypes;
}
