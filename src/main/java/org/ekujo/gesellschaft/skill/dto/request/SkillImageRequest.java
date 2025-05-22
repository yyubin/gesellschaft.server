package org.ekujo.gesellschaft.skill.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillImageRequest {
    private Long id;
    private String url;
}
