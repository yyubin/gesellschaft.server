package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "season")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    @Setter
    private String name;

    @Builder
    public Season(String name) {
        this.name = name;
    }
}
