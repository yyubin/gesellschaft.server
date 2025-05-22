package org.ekujo.gesellschaft.skill.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveSkillUpdateRequest {
    private Long id;
    private int syncLevel;
    private String skillIndex;
    private String skillName;
    private String attackType; // enum name
    private Long sinPropertyId;
    private int quantity;
    private int attackLevel;
    private DamageSpecDto damageSpec;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DamageSpecDto {
        private int basePower;
        private int coinPower;
        private int coinCount;
        private int weight;
    }
}