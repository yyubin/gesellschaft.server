package org.ekujo.gesellschaft.skill.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActiveSkillCreateRequest {
    private Long personaId;
    private Integer syncLevel;
    private String skillIndex;
    private String skillName;
    private String attackType; // Enum 이름 문자열
    private Long sinPropertyId;
    private Integer quantity;
    private DamageSpecDto damageSpec;
    private Integer attackLevel;

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