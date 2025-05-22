package org.ekujo.gesellschaft.persona.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaCreateRequest {
    private Integer characterId;
    private String name;
    private Integer rarity;

    private Integer health;
    private Integer mental;
    private Integer minSpeed;
    private Integer maxSpeed;
    private Integer guardLevel;

    private Long seasonId;
    private LocalDateTime releaseDate;

    private ResistanceDto resistance;
    private DisturbedSetDto disturbed;
    private List<Long> traitIds;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResistanceDto {
        private String attack;
        private String penetration;
        private String batting;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DisturbedSetDto {
        private Long disturbed1;
        private Long disturbed2;
        private Long disturbed3;
    }
}
