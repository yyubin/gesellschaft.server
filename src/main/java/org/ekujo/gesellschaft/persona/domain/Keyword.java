package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "keyword")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Keyword {

    @Id
    private Integer id;

    @Column(name = "keyword_name", nullable = false, length = 10)
    @Setter
    private String name;

    @Builder
    public Keyword(String name) {
        this.name = name;
    }
}