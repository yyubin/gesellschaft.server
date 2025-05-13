package org.ekujo.gesellschaft.skill.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;

@Entity
@Table(name = "active_skill")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ActiveSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Column(name = "sync_level")
    private int syncLevel;

    @Column(name = "skill_index")
    private String skillIndex;

    @Column(name = "skill_name")
    private String skillName;

    @Enumerated(EnumType.STRING)
    @Column(name = "attack_type")
    private AttackType attackType;

    @ManyToOne
    @JoinColumn(name = "sinProperty_id", nullable = false)
    private SinProperty sinProperty;

    @Column(name = "quantity")
    private int quantity;

    @Embedded
    private DamageSpec damageSpec;

    @Column(name = "attack_level")
    private int attackLevel;
}
