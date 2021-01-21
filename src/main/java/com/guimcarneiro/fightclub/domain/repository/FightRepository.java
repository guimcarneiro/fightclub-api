package com.guimcarneiro.fightclub.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guimcarneiro.fightclub.domain.model.Fight;

public interface FightRepository extends JpaRepository<Fight, Long> {

}
