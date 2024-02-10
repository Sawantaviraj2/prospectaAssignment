package com.prospectaapplication1.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ApiCategory {

	@Id
	private String name;

	@OneToMany(mappedBy = "category")
	private List<ApiEntry> apiEntries;

	public ApiCategory() {
	}

	public ApiCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ApiEntry> getApiEntries() {
		return apiEntries;
	}

	public void setApiEntries(List<ApiEntry> apiEntries) {
		this.apiEntries = apiEntries;
	}
}
