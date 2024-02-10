package com.prospectaapplication1.service;

import java.util.List;

import com.prospectaapplication1.entity.ApiEntry;

public interface ApiEntryService {

	public List<ApiEntry> getAllEntries();

	public ApiEntry getEntryById(Long entryId);

	public void saveEntry(ApiEntry entry);

	public void deleteEntry(Long entryId);
}
