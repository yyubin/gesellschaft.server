package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.response.TraitResponse;

import java.util.List;

public interface TraitService {
    List<TraitResponse> findAll();
    TraitResponse createKeyword(String traitName);
    TraitResponse updateKeyword(Long traitId, String updatedTraitName);
}
