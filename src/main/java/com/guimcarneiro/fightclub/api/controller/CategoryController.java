package com.guimcarneiro.fightclub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimcarneiro.fightclub.api.model.CreateCategoryModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowCategory;
import com.guimcarneiro.fightclub.api.service.CategoryApiService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryApiService categoryApiService;
	
	@PostMapping
	public ResponseEntity<CreateCategoryModel> create(@RequestBody CreateCategoryModel ccm) {
		return this.categoryApiService.save(ccm);
	}
	
	@GetMapping
	public ResponseEntity<List<DefaultShowCategory>> listAll() {
		return this.categoryApiService.listAll();
	}
	
}