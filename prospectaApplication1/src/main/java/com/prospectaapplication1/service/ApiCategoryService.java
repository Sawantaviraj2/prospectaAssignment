package com.prospectaapplication1.service;

import java.util.List;

import com.prospectaapplication1.entity.ApiCategory;

public interface ApiCategoryService {

	public List<ApiCategory> getAllCategories();

	public ApiCategory getCategoryByName(String categoryName);

	public void saveCategory(ApiCategory category);

	public void deleteCategory(String categoryName);
}
