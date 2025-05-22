package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Season;
import org.ekujo.gesellschaft.persona.dto.SeasonDto;
import org.ekujo.gesellschaft.persona.dto.request.SeasonCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.SeasonUpdateRequest;
import org.ekujo.gesellschaft.persona.mapper.SeasonMapper;
import org.ekujo.gesellschaft.persona.respository.SeasonRepository;
import org.ekujo.gesellschaft.persona.service.SeasonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;

    public Season findById(Long id) {
        return seasonRepository.findById(id).orElse(null);
    }

    public List<SeasonDto> findAll() {
        List<Season> seasons = seasonRepository.findAll();
        return seasons.stream().map(seasonMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public SeasonDto create(SeasonCreateRequest seasonCreateRequest) {
        Season save = seasonRepository.save(Season.builder().name(seasonCreateRequest.getName()).build());
        return seasonMapper.toDto(save);
    }

    @Transactional
    public SeasonDto update(SeasonUpdateRequest seasonUpdateRequest) {
        Season season = seasonRepository.findById(seasonUpdateRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Id " + seasonUpdateRequest.getId() + " not found"));
        season.setName(seasonUpdateRequest.getName());
        return seasonMapper.toDto(seasonRepository.save(season));
    }
}
