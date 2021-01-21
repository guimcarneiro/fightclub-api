package com.guimcarneiro.fightclub.api.mapper;

import com.guimcarneiro.fightclub.api.model.DefaultShowCategory;
import com.guimcarneiro.fightclub.domain.model.Category;

public class CategoryMapper {

	/**
	 * It maps Category to DefaultShowCategory.
	 * 
	 * @param category
	 * @param dsc
	 */
	public static void mapCategoryToDefaultShowCategory(Category category, DefaultShowCategory dsc) {
		dsc.setName(category.getName());
		dsc.setDescription(category.getDescription());
	}
	
}
