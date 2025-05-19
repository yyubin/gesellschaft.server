package org.ekujo.gesellschaft.persona.respository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.ekujo.gesellschaft.persona.domain.QPersona;

import java.util.List;

@RequiredArgsConstructor
public class PersonaRepositoryImpl implements PersonaRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Persona> searchWithFilters(
            List<String> characterIds,
            List<String> sinIds,
            List<String> keywordIds,
            List<String> attackTypes,
            Pageable pageable
    ) {
        QPersona persona = QPersona.persona;

        BooleanBuilder where = new BooleanBuilder();

        if (!characterIds.isEmpty()) {
            where.and(persona.character.id.in((Number) characterIds));
        }

        List<Persona> content = queryFactory
                .selectFrom(persona)
                .where(where)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(persona.count())
                .from(persona)
                .where(where)
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }


}
