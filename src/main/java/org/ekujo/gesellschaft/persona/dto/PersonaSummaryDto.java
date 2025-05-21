package org.ekujo.gesellschaft.persona.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Builder
public class PersonaSummaryDto {
    private Integer id;
    private String name;
    private String characterName;
    private Integer rarity;
    private Integer health;
    private String season;
    private LocalDateTime releaseDate;
    private Integer mental;
}