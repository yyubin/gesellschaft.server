package org.ekujo.gesellschaft.character.service;

import org.ekujo.gesellschaft.character.dto.GameCharacterDto;

import java.util.List;

public interface GameCharacterService {
    List<GameCharacterDto> findAll();
}
