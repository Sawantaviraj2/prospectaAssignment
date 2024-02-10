package com.prospectaapplication1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospectaapplication1.entity.ApiEntry;
import com.prospectaapplication1.exception.ResourceNotFoundException;
import com.prospectaapplication1.repository.ApiEntryRepository;
@Service
public class ApiEntryServiceImpl implements ApiEntryService {

	private final ApiEntryRepository entryRepository;

	@Autowired
	public ApiEntryServiceImpl(ApiEntryRepository entryRepository) {
		super();
		this.entryRepository = entryRepository;
	}

	public List<ApiEntry> getAllEntries() {
		return entryRepository.findAll();
	}

	public ApiEntry getEntryById(Long entryId) {
		return entryRepository.findById(entryId)
				.orElseThrow(() -> new ResourceNotFoundException("API entry not found with ID: " + entryId));
	}

	public void saveEntry(ApiEntry entry) {
		entryRepository.save(entry);
	}

	public void deleteEntry(Long entryId) {
		if (!entryRepository.existsById(entryId)) {
			throw new ResourceNotFoundException("API entry not found with ID: " + entryId);
		}
		entryRepository.deleteById(entryId);
	}

}
