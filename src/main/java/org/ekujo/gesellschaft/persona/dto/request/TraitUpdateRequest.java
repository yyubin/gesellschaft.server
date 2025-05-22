package org.ekujo.gesellschaft.persona.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraitUpdateRequest {
    private Long id;
    private String traitName;
}