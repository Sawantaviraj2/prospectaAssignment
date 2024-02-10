package com.prospectaapplication1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospectaapplication1.entity.ApiEntry;

public interface ApiEntryRepository extends JpaRepository<ApiEntry, Long> {
	// Additional custom queries can be added here if needed
}
