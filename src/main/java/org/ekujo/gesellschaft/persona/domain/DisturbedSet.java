package org.ekujo.gesellschaft.persona.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisturbedSet {
    @Column(name = "disturbed1", length = 20)
    private Long disturbed1;

    @Column(name = "disturbed2", length = 20)
    private Long disturbed2;

    @Column(name = "disturbed3", length = 20)
    private Long disturbed3;
}
