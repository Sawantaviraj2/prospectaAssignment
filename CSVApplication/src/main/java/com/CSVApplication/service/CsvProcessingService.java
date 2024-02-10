package com.CSVApplication.service;

import com.CSVApplication.entity.CsvTable;

public interface CsvProcessingService {

	public String processCsv(String csvInput);

	public CsvTable parseCsvData(String csvInput);

	public void calculateCsvTable(CsvTable csvTable);

	public String convertToCsvOutput(CsvTable csvTable);
}
