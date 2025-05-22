package org.ekujo.gesellschaft.character.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.ekujo.gesellschaft.character.dto.GameCharacterDto;
import org.ekujo.gesellschaft.character.mapper.GameCharacterMapper;
import org.ekujo.gesellschaft.character.respository.GameCharacterRepository;
import org.ekujo.gesellschaft.character.service.GameCharacterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameCharacterServiceImpl implements GameCharacterService {

    private final GameCharacterRepository gameCharacterRepository;
    private final GameCharacterMapper gameCharacterMapper;

    public List<GameCharacterDto> findAll() {
        List<GameCharacter> all = gameCharacterRepository.findAll();
        return all.stream().map(gameCharacterMapper::toDto).collect(Collectors.toList());
    }
}
