package com.prospectaapplication1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ApiEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_name")
	private ApiCategory category;

	public ApiEntry() {
	}

	public ApiEntry(String title, String description, ApiCategory category) {
		this.title = title;
		this.description = description;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ApiCategory getCategory() {
		return category;
	}

	public void setCategory(ApiCategory category) {
		this.category = category;
	}
}
