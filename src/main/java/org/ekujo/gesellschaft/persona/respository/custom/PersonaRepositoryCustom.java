package org.ekujo.gesellschaft.persona.respository.custom;

import org.ekujo.gesellschaft.persona.domain.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaRepositoryCustom {
    Page<Persona> searchWithFilters(
            List<String> characterIds,
            List<String> sinIds,
            List<String> keywordIds,
            List<String> attackTypes,
            Pageable pageable
    );
}
