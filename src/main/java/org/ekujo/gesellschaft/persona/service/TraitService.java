package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.domain.PersonaTrait;
import org.ekujo.gesellschaft.persona.domain.Trait;
import org.ekujo.gesellschaft.persona.dto.response.TraitResponse;

import java.util.List;

public interface TraitService {
    List<PersonaTrait> findListsByIds(List<Long> traitIds, Long personaId);
    Trait findById(Long traitId);
    List<Trait> findByIds(List<Long> traitIds);
    List<TraitResponse> findAll();
    TraitResponse createTrait(String traitName);
    TraitResponse updateTrait(Long traitId, String updatedTraitName);
}
