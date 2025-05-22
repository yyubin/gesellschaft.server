package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.response.TraitResponse;

import java.util.List;

public interface TraitService {
    List<TraitResponse> findAll();
    TraitResponse createTrait(String traitName);
    TraitResponse updateTrait(Long traitId, String updatedTraitName);
}
