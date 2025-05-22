package org.ekujo.gesellschaft.skill.repository;

import org.ekujo.gesellschaft.skill.domain.ActiveSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveSkillRepository extends JpaRepository<ActiveSkill, Long> {
}
