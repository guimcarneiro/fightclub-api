package com.guimcarneiro.fightclub.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guimcarneiro.fightclub.domain.model.Category;

public interface CategoryRepository  extends JpaRepository<Category, String> {

}
