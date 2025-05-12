package org.ekujo.gesellschaft.character.respository;

import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {
}
