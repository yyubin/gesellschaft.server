package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persona_trait")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PersonaTrait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    @Setter
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trait_id", nullable = false)
    @Setter
    private Trait trait;

    @Builder
    public PersonaTrait(Persona persona, Trait trait) {
        this.persona = persona;
        this.trait = trait;
    }
}