package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "persona_image")
@Getter
public class PersonaImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @Setter
    private Persona persona;

    @Column(columnDefinition = "TEXT")
    @Setter
    private String imageA;

    @Column(columnDefinition = "TEXT")
    @Setter
    private String imageAc;

    @Column(columnDefinition = "TEXT")
    @Setter
    private String imageSd;

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

}
