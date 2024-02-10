package com.CSVApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CSVApplication.service.CsvProcessingService;

@RestController
public class CsvProcessingController {

	private final CsvProcessingService csvProcessingService;

	@Autowired
	public CsvProcessingController(CsvProcessingService csvProcessingService) {
		this.csvProcessingService = csvProcessingService;
	}

	@PostMapping("/process-csv")
	public ResponseEntity<String> processCsv(@RequestBody String csvInput) {
		try {
			String processedCsv = csvProcessingService.processCsv(csvInput);
			return ResponseEntity.ok(processedCsv);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
