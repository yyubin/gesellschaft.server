package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trait")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Trait {

    @Id
    private Integer id;

    @Column(name = "trait_name", nullable = false, length = 20)
    @Setter
    private String name;

    @Builder
    public Trait(String name) {
        this.name = name;
    }
}