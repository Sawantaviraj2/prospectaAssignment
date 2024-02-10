package com.prospectaapplication1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospectaapplication1.entity.ApiCategory;
import com.prospectaapplication1.exception.ResourceNotFoundException;
import com.prospectaapplication1.repository.ApiCategoryRepository;

@Service
public class ApiCategoryServiceImpl implements ApiCategoryService {

	private final ApiCategoryRepository categoryRepository;

	@Autowired
	public ApiCategoryServiceImpl(ApiCategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<ApiCategory> getAllCategories() {
		return categoryRepository.findAll();
	}

	public ApiCategory getCategoryByName(String categoryName) {
		return categoryRepository.findById(categoryName)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found: " + categoryName));

	}

	public void saveCategory(ApiCategory category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(String categoryName) {

		if (!categoryRepository.existsById(categoryName)) {
			throw new ResourceNotFoundException("Category not found: " + categoryName);
		}
		categoryRepository.deleteById(categoryName);
	}

}
