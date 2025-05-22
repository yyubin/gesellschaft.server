package org.ekujo.gesellschaft.persona.dto;

import lombok.Builder;
import lombok.Getter;
import org.ekujo.gesellschaft.persona.domain.ResistanceLevel;
import org.ekujo.gesellschaft.skill.domain.AttackType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PersonaDetailDto {

    private Integer id;
    private CharacterDto character;
    private Integer rarity;
    private String name;
    private Integer health;

    private Integer minSpeed;
    private Integer maxSpeed;
    private Integer guardLevel;

    private ResistanceDto resistance;

    private String season;
    private LocalDateTime releaseDate;
    private Integer mental;

    private List<TraitDto> traits;
    private List<ActiveSkillDto> activeSkills;

    /* ---------- nested DTOs ---------- */

    @Getter
    @Builder
    public static class CharacterDto {
        private Integer id;
        private String name;
        private String nameKo;
    }

    @Getter
    @Builder
    public static class ResistanceDto {
        private ResistanceLevel attack;
        private ResistanceLevel penetration;
        private ResistanceLevel batting;
    }

    @Getter
    @Builder
    public static class TraitDto {
        private Integer id;
        private String name;
    }

    @Getter
    @Builder
    public static class ActiveSkillDto {

        private Long id;
        private Integer syncLevel;
        private String skillIndex;
        private String skillName;

        private AttackType attackType;
        private SinPropertyDto sinProperty;

        private Integer quantity;
        private DamageSpecDto damageSpec;
        private Integer attackLevel;
    }

    @Getter
    @Builder
    public static class SinPropertyDto {
        private Integer id;
        private String name;
    }

    @Getter
    @Builder
    public static class DamageSpecDto {
        private Integer basePower;
        private Integer coinPower;
        private Integer coinCount;
        private Integer weight;
    }
}
