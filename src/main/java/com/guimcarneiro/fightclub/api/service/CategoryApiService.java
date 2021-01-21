package com.guimcarneiro.fightclub.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guimcarneiro.fightclub.api.mapper.CategoryMapper;
import com.guimcarneiro.fightclub.api.model.CreateCategoryModel;
import com.guimcarneiro.fightclub.api.model.DefaultShowCategory;
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
	
	public ResponseEntity<List<DefaultShowCategory>> listAll() {
		List<DefaultShowCategory> categoriesModels = new ArrayList<>();
		
		List<Category> categoriesDb = this.categoryRepository.findAll();
		
		for (Category category : categoriesDb) {
			DefaultShowCategory dsc = new DefaultShowCategory();
			CategoryMapper.mapCategoryToDefaultShowCategory(category, dsc);
			
			categoriesModels.add(dsc);
		}
		
		return new ResponseEntity<>(categoriesModels, HttpStatus.OK);
	}
}
