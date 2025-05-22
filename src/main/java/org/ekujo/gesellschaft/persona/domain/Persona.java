package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.ekujo.gesellschaft.persona.dto.request.PersonaImageRequest;
import org.ekujo.gesellschaft.persona.dto.request.PersonaUpdateRequest;
import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.domain.SinProperty;

import static org.ekujo.gesellschaft.persona.domain.PersonaImageType.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Integer mental;

    @Embedded
    private DisturbedSet disturbed;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonaTrait> traits = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActiveSkill> activeSkills = new ArrayList<>();

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonaImage personaImage = new PersonaImage();

    public static Persona create(
            GameCharacter character,
            String name,
            int rarity,
            int health,
            int minSpeed,
            int maxSpeed,
            int guardLevel,
            ResistanceSet resistance,
            Season season,
            LocalDateTime releaseDate,
            int mental,
            DisturbedSet disturbed,
            List<ActiveSkill> activeSkills,
            List<PersonaTrait> traits
    ) {
        Persona persona = new Persona();

        persona.character = character;
        persona.name = name;
        persona.rarity = rarity;
        persona.health = health;
        persona.minSpeed = minSpeed;
        persona.maxSpeed = maxSpeed;
        persona.guardLevel = guardLevel;
        persona.resistance = resistance;
        persona.season = season;
        persona.releaseDate = releaseDate;
        persona.mental = mental;
        persona.disturbed = disturbed;

        persona.traits = new ArrayList<>();
        for (PersonaTrait trait : traits) {
            trait.setPersona(persona);
            persona.traits.add(trait);
        }

        persona.activeSkills = new ArrayList<>();
        for (ActiveSkill skill : activeSkills) {
            skill.setPersona(persona);
            persona.activeSkills.add(skill);
        }

        PersonaImage image = new PersonaImage();
        image.setPersona(persona);
        persona.personaImage = image;

        return persona;
    }


    public void setPersonaImage(PersonaImage image) {
        this.personaImage = image;
        image.setPersona(this);
    }

    public void updatePersonaImage(PersonaImageRequest personaImageRequest) {
        PersonaImageType type = PersonaImageType.valueOf(personaImageRequest.getImageType());
        switch (type) {
            case A -> personaImage.setImageA(personaImageRequest.getImageUrl());
            case AC -> personaImage.setImageAc(personaImageRequest.getImageUrl());
            case SD -> personaImage.setImageSd(personaImageRequest.getImageUrl());
        }
    }

    public void updatePersona(PersonaUpdateRequest req, GameCharacter character, Season season, List<PersonaTrait> newTraits) {
        this.character = character;
        this.name = req.getName();
        this.rarity = req.getRarity();
        this.health = req.getHealth();
        this.mental = req.getMental();
        this.minSpeed = req.getMinSpeed();
        this.maxSpeed = req.getMaxSpeed();
        this.guardLevel = req.getGuardLevel();
        this.season = season;
        this.releaseDate = req.getReleaseDate();

        // Resistance
        PersonaUpdateRequest.ResistanceDto r = req.getResistance();
        this.resistance = new ResistanceSet(ResistanceLevel.fromString(r.getAttack()),
                ResistanceLevel.fromString(r.getPenetration()),
                ResistanceLevel.fromString(r.getBatting()));

        // Disturbed
        PersonaUpdateRequest.DisturbedSetDto d = req.getDisturbed();
        this.disturbed = new DisturbedSet(d.getDisturbed1(), d.getDisturbed2(), d.getDisturbed3());

        // Traits (연관관계 재설정)
        this.traits.clear();
        for (PersonaTrait trait : newTraits) {
            trait.setPersona(this);
            this.traits.add(trait);
        }
    }


}