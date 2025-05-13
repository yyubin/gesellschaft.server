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

    @Embedded
    private ResistanceSet resistance;

    @Column(length = 10)
    private String season;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Integer mental;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonaTrait> traits = new ArrayList<>();
}