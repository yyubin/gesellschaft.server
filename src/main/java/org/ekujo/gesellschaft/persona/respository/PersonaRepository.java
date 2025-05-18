package org.ekujo.gesellschaft.persona.respository;

import org.ekujo.gesellschaft.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByCharacter_Id(Integer characterId);
}
