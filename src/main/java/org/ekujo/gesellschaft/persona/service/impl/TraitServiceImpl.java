package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Keyword;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.ekujo.gesellschaft.persona.domain.PersonaTrait;
import org.ekujo.gesellschaft.persona.domain.Trait;
import org.ekujo.gesellschaft.persona.dto.response.KeywordResponse;
import org.ekujo.gesellschaft.persona.dto.response.TraitResponse;
import org.ekujo.gesellschaft.persona.mapper.TraitMapper;
import org.ekujo.gesellschaft.persona.respository.TraitRepository;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.ekujo.gesellschaft.persona.service.TraitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TraitServiceImpl implements TraitService {

    private final TraitRepository traitRepository;
    private final TraitMapper traitMapper;
    private final PersonaService personaService;

    public List<PersonaTrait> findListsByIds(List<Long> traitIds, Long personaId) {
        Persona persona = personaService.getPersonaById(personaId);
        return traitIds.stream()
                .map(traitId -> {
                    Trait trait = traitRepository.findById(traitId)
                            .orElseThrow(() -> new NoSuchElementException("Trait not found: " + traitId));
                    return PersonaTrait.builder()
                            .persona(persona)
                            .trait(trait)
                            .build();
                })
                .toList();
    }

    public Trait findById(Long traitId) {
        return traitRepository.findById(traitId).orElseThrow(() -> new NoSuchElementException("Trait not found: " + traitId));
    }

    public List<Trait> findByIds(List<Long> traitIds) {
        return traitRepository.findAllById(traitIds);
    }

    public List<TraitResponse> findAll() {
        List<Trait> traits = traitRepository.findAll();
        return traits.stream().map(traitMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public TraitResponse createTrait(String traitName) {
        Trait save = traitRepository.save(Trait.builder().name(traitName).build());
        return traitMapper.toResponse(save);
    }

    @Transactional
    public TraitResponse updateTrait(Long traitId, String updatedTraitName) {
        Trait save = traitRepository.findById(traitId).orElseThrow(() -> new NoSuchElementException("Trait not found"));
        save.setName(updatedTraitName);
        return traitMapper.toResponse(traitRepository.save(save));
    }
}
