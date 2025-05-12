package org.ekujo.gesellschaft.persona.respository;

import org.ekujo.gesellschaft.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
}
