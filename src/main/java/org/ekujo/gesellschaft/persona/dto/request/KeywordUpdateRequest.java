package org.ekujo.gesellschaft.persona.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeywordUpdateRequest {
    private Long id;
    private String keywordName;
}
