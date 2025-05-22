package org.ekujo.gesellschaft.skill.domain;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class DamageSpec {
    private int basePower;
    private int coinPower;
    private int coinCount;
    private int weight;

    @Builder
    public DamageSpec(int basePower, int coinPower, int coinCount, int weight) {
        this.basePower = basePower;
        this.coinPower = coinPower;
        this.coinCount = coinCount;
        this.weight = weight;
    }
}
