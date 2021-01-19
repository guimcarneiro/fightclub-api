package com.guimcarneiro.fightclub.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.api.model.CreateCategoryModel;
import com.guimcarneiro.fightclub.domain.model.Category;
import com.guimcarneiro.fightclub.domain.repository.CategoryRepository;

@Service
public class CategoryApiService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public ResponseEntity<CreateCategoryModel> save(CreateCategoryModel ccm) {
		Category newCategory = new Category();
		newCategory.setName(ccm.getName());
		newCategory.setDescription(ccm.getName());
		
		Category categoryDb = this.categoryRepository.save(newCategory);
		
		CreateCategoryModel savedCategoryModel = new CreateCategoryModel();
		savedCategoryModel.setName(categoryDb.getName());
		savedCategoryModel.setDescription(categoryDb.getDescription());
		
		return new ResponseEntity<>(savedCategoryModel, HttpStatus.CREATED);
	}
}
