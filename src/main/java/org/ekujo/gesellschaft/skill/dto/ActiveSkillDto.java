package org.ekujo.gesellschaft.skill.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActiveSkillDto {
    private Long id;
    private Integer syncLevel;
    private String skillIndex;
    private String skillName;
    private String attackType;
    private String sinPropertyName;
    private Integer quantity;
    private Integer attackLevel;
    private DamageSpecDto damageSpec;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DamageSpecDto {
        private Integer basePower;
        private Integer coinPower;
        private Integer coinCount;
        private Integer weight;
    }
}
