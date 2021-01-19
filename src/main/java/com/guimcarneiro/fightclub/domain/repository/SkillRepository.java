package com.guimcarneiro.fightclub.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guimcarneiro.fightclub.domain.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
