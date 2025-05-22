package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class ResistanceSet {
    @Enumerated(EnumType.STRING)
    @Column(name = "attack_resistance", length = 10)
    private ResistanceLevel attack;

    @Enumerated(EnumType.STRING)
    @Column(name = "penetration_resistance", length = 10)
    private ResistanceLevel penetration;

    @Enumerated(EnumType.STRING)
    @Column(name = "batting_resistance", length = 10)
    private ResistanceLevel batting;

    public ResistanceSet(ResistanceLevel attack, ResistanceLevel penetration, ResistanceLevel batting) {
        this.attack = attack;
        this.penetration = penetration;
        this.batting = batting;
    }
}
