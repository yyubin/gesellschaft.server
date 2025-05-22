package org.ekujo.gesellschaft.character.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`character`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GameCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    @Setter
    private String name;

    @Column(name = "name_ko", length = 5)
    @Setter
    private String nameKo;

    @Builder
    public GameCharacter(String name, String nameKo) {
        this.name = name;
        this.nameKo = nameKo;
    }
}