package org.ekujo.gesellschaft.skill.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sin_property")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SinProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 10, nullable = false)
    @Setter
    private String name;

    @Builder
    public SinProperty(String name) {
        this.name = name;
    }
}