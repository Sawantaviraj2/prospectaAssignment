package com.prospectaapplication1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prospectaapplication1.entity.ApiCategory;
import com.prospectaapplication1.service.ApiCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ApiCategoryController {

	private final ApiCategoryService categoryService;

	@Autowired
	public ApiCategoryController(ApiCategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping
	public List<ApiCategory> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{categoryName}")
	public ApiCategory getCategoryByName(@PathVariable String categoryName) {
		return categoryService.getCategoryByName(categoryName);
	}

	@PostMapping
	public void saveCategory(@RequestBody ApiCategory category) {
		categoryService.saveCategory(category);
	}

	@DeleteMapping("/{categoryName}")
	public void deleteCategory(@PathVariable String categoryName) {
		categoryService.deleteCategory(categoryName);
	}
}
