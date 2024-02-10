package com.prospectaapplication1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prospectaapplication1.entity.ApiEntry;
import com.prospectaapplication1.service.ApiEntryService;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class ApiEntryController {

	private final ApiEntryService entryService;

	@Autowired
	public ApiEntryController(ApiEntryService entryService) {
		this.entryService = entryService;
	}

	@GetMapping
	public List<ApiEntry> getAllEntries() {
		return entryService.getAllEntries();
	}

	@GetMapping("/{entryId}")
	public ApiEntry getEntryById(@PathVariable Long entryId) {
		return entryService.getEntryById(entryId);
	}

	@PostMapping
	public void saveEntry(@RequestBody ApiEntry entry) {
		entryService.saveEntry(entry);
	}

	@DeleteMapping("/{entryId}")
	public void deleteEntry(@PathVariable Long entryId) {
		entryService.deleteEntry(entryId);
	}
}
