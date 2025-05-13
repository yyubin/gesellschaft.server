package org.ekujo.gesellschaft.skill.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class DamageSpec {
    private int basePower;
    private int coinPower;
    private int coinCount;
    private int weight;
}
