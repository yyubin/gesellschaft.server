package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.base.dto.PageResultDto;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.PersonaSummaryDto;
import org.ekujo.gesellschaft.persona.exception.PersonaErrorCode;
import org.ekujo.gesellschaft.persona.exception.PersonaException;
import org.ekujo.gesellschaft.persona.mapper.PersonaMapper;
import org.ekujo.gesellschaft.persona.respository.PersonaRepository;
import org.ekujo.gesellschaft.persona.respository.custom.PersonaRepositoryCustom;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;
    private final PersonaRepositoryCustom personaRepositoryCustom;
    private final PersonaMapper personaMapper;

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public PersonaDetailDto getPersonaDetail(Long id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new PersonaException(PersonaErrorCode.PERSONA_NOT_FOUND));
        return personaMapper.toDto(persona);
    }

    public List<PersonaDetailDto> getPersonaDetailsByCharacterId(Long characterId) {
        List<Persona> byCharacterId = personaRepository.findByCharacter_Id(Math.toIntExact(characterId));
        return byCharacterId.stream().map(personaMapper::toDto).collect(Collectors.toList());
    }

    public PageResultDto<PersonaSummaryDto> getAllPersonaDetails(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Persona> personaPage = personaRepository.findAll(pageable);

        List<PersonaSummaryDto> content = personaPage
                .getContent()
                .stream()
                .map(personaMapper::toSummaryDto)
                .collect(Collectors.toList());

        return PageResultDto.<PersonaSummaryDto>builder()
                .content(content)
                .totalPages(personaPage.getTotalPages())
                .totalElements(personaPage.getTotalElements())
                .build();
    }

    public PageResultDto<PersonaSummaryDto> getAllPersonaDetails(int page, int size, String sortBy, String name, Long characterId) {
        Pageable pageable = PageRequest.of(page, size, getSort(sortBy));

        Page<Persona> personaPage = personaRepositoryCustom.findAllWithFilters(name, characterId, pageable);

        List<PersonaSummaryDto> content = personaPage.getContent()
                .stream()
                .map(personaMapper::toSummaryDto)
                .collect(Collectors.toList());

        return PageResultDto.<PersonaSummaryDto>builder()
                .content(content)
                .totalPages(personaPage.getTotalPages())
                .totalElements(personaPage.getTotalElements())
                .build();
    }

    private Sort getSort(String sortBy) {
        if ("name".equalsIgnoreCase(sortBy)) {
            return Sort.by(Sort.Direction.ASC, "name");
        }
        return Sort.by(Sort.Direction.DESC, "id");
    }
}
