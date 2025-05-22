package org.ekujo.gesellschaft.skill.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.ActiveSkillUpdateRequest;

import java.time.LocalDateTime;

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
    @Setter
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
    @JoinColumn(name = "sin_property_id", nullable = false)
    private SinProperty sinProperty;

    @Column(name = "quantity")
    private int quantity;

    @Embedded
    private DamageSpec damageSpec;

    @Column(name = "attack_level")
    private int attackLevel;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String skillImage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Builder
    public ActiveSkill(Persona persona, int syncLevel, String skillIndex, String skillName, AttackType attackType, SinProperty sinProperty, int quantity, DamageSpec damageSpec, int attackLevel) {
        this.persona = persona;
        this.syncLevel = syncLevel;
        this.skillIndex = skillIndex;
        this.skillName = skillName;
        this.attackType = attackType;
        this.sinProperty = sinProperty;
        this.quantity = quantity;
        this.damageSpec = damageSpec;
        this.attackLevel = attackLevel;
    }

    public void update(ActiveSkillUpdateRequest req, SinProperty sinProperty) {
        this.syncLevel = req.getSyncLevel();
        this.skillIndex = req.getSkillIndex();
        this.skillName = req.getSkillName();
        this.attackType = AttackType.valueOf(req.getAttackType());
        this.sinProperty = sinProperty;
        this.quantity = req.getQuantity();
        this.attackLevel = req.getAttackLevel();

        this.damageSpec = DamageSpec.builder()
                .basePower(req.getDamageSpec().getBasePower())
                .coinPower(req.getDamageSpec().getCoinPower())
                .coinCount(req.getDamageSpec().getCoinCount())
                .weight(req.getDamageSpec().getWeight())
                .build();
    }
}
