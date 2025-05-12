package org.ekujo.gesellschaft.persona.respository;

import org.ekujo.gesellschaft.persona.domain.Trait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<Trait, Long> {
}
