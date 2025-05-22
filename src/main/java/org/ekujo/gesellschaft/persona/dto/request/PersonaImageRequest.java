package org.ekujo.gesellschaft.persona.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaImageRequest {
    private Long personaId;
    private String imageType;
    private String imageUrl;
}
