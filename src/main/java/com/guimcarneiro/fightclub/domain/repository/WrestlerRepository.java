package com.guimcarneiro.fightclub.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guimcarneiro.fightclub.domain.model.Wrestler;

@Repository
public interface WrestlerRepository extends JpaRepository<Wrestler, Long> {

}
