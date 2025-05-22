package org.ekujo.gesellschaft.character.service;

import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.ekujo.gesellschaft.character.dto.GameCharacterDto;

import java.util.List;

public interface GameCharacterService {
    List<GameCharacterDto> findAll();
    GameCharacter findById(Long id);
}
