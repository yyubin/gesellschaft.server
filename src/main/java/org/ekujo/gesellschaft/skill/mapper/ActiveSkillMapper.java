package org.ekujo.gesellschaft.skill.mapper;

import org.ekujo.gesellschaft.persona.mapper.PersonaMapper;
import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.ekujo.gesellschaft.skill.dto.response.SkillImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PersonaMapper.class)
public interface ActiveSkillMapper {
    @Mapping(source = "persona", target = "persona")
    SkillImageResponse toSkillImageResponse(ActiveSkill activeSkill);
}
