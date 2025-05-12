package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.ekujo.gesellschaft.character.domain.GameCharacter;

@Entity
@Table(name = "persona")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private GameCharacter character;

    private Integer rarity;

    @Column(length = 18)
    private String name;

    private Integer health;

    @Column(name = "min_speed")
    private Integer minSpeed;

    @Column(name = "max_speed")
    private Integer maxSpeed;

    @Column(name = "guard_level")
    private Integer guardLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "attack_resistance", length = 10)
    private ResistanceLevel attackResistance;

    @Enumerated(EnumType.STRING)
    @Column(name = "penetration_resistance", length = 10)
    private ResistanceLevel penetrationResistance;

    @Enumerated(EnumType.STRING)
    @Column(name = "batting_resistance", length = 10)
    private ResistanceLevel battingResistance;

    @Column(length = 10)
    private String season;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Integer mental;

    @Column(name = "column_15")
    private Integer column15;

    @Column(name = "column_16")
    private Integer column16;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonaTrait> traits = new ArrayList<>();
}