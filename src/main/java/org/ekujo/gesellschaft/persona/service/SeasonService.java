package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.domain.Season;
import org.ekujo.gesellschaft.persona.dto.SeasonDto;
import org.ekujo.gesellschaft.persona.dto.request.SeasonCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.SeasonUpdateRequest;

import java.util.List;

public interface SeasonService {
    Season findById(Long id);
    List<SeasonDto> findAll();
    SeasonDto create(SeasonCreateRequest seasonCreateRequest);
    SeasonDto update(SeasonUpdateRequest seasonUpdateRequest);
}
