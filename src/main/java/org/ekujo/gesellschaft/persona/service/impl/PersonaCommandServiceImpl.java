package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.character.domain.GameCharacter;
import org.ekujo.gesellschaft.character.service.GameCharacterService;
import org.ekujo.gesellschaft.persona.domain.*;
import org.ekujo.gesellschaft.persona.dto.PersonaDetailDto;
import org.ekujo.gesellschaft.persona.dto.request.PersonaCreateRequest;
import org.ekujo.gesellschaft.persona.dto.request.PersonaUpdateRequest;
import org.ekujo.gesellschaft.persona.mapper.PersonaMapper;
import org.ekujo.gesellschaft.persona.respository.PersonaRepository;
import org.ekujo.gesellschaft.persona.service.PersonaCommandService;
import org.ekujo.gesellschaft.persona.service.PersonaService;
import org.ekujo.gesellschaft.persona.service.SeasonService;
import org.ekujo.gesellschaft.persona.service.TraitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonaCommandServiceImpl implements PersonaCommandService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final PersonaService personaService;
    private final GameCharacterService gameCharacterService;
    private final SeasonService seasonService;
    private final TraitService traitService;

    public PersonaDetailDto updatePersona(PersonaUpdateRequest personaUpdateRequest) {
        Persona personaById = personaService.getPersonaById(personaUpdateRequest.getId());
        GameCharacter character = gameCharacterService.findById(Long.valueOf(personaUpdateRequest.getCharacterId()));
        Season season = seasonService.findById(personaUpdateRequest.getSeasonId());
        List<PersonaTrait> listsByIds = traitService.findListsByIds(personaUpdateRequest.getTraitIds(), Long.valueOf(personaById.getId()));
        personaById.updatePersona(personaUpdateRequest, character, season, listsByIds);
        return personaMapper.toDto(personaById);
    }

    public PersonaDetailDto createPersona(PersonaCreateRequest req) {
        GameCharacter character = gameCharacterService.findById(Long.valueOf(req.getCharacterId()));
        Season season = seasonService.findById(req.getSeasonId());
        List<Trait> traits = traitService.findByIds(req.getTraitIds());
        List<PersonaTrait> personaTraits = traits.stream()
                .map(trait -> new PersonaTrait(null, trait))
                .toList();

        ResistanceSet resistance = new ResistanceSet(
                ResistanceLevel.fromString(req.getResistance().getAttack()),
                ResistanceLevel.fromString(req.getResistance().getPenetration()),
                ResistanceLevel.fromString(req.getResistance().getBatting())
        );

        DisturbedSet disturbed = new DisturbedSet(
                req.getDisturbed().getDisturbed1(),
                req.getDisturbed().getDisturbed2(),
                req.getDisturbed().getDisturbed3()
        );

        Persona persona = Persona.create(
                character,
                req.getName(),
                req.getRarity(),
                req.getHealth(),
                req.getMinSpeed(),
                req.getMaxSpeed(),
                req.getGuardLevel(),
                resistance,
                season,
                req.getReleaseDate(),
                req.getMental(),
                disturbed,
                List.of(),
                personaTraits
        );

        return personaMapper.toDto(personaRepository.save(persona));
    }

}
