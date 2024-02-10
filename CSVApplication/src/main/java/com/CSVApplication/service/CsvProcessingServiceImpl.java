package com.CSVApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSVApplication.entity.Cell;
import com.CSVApplication.entity.CsvTable;
import com.CSVApplication.entity.Row;
import com.CSVApplication.exception.CircularReferenceException;
import com.CSVApplication.exception.DivideByZeroException;
import com.CSVApplication.exception.InvalidCsvFormatException;
import com.CSVApplication.repository.CellRepository;
import com.CSVApplication.repository.CsvTableRepository;
import com.CSVApplication.repository.RowRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class CsvProcessingServiceImpl implements CsvProcessingService {

	private final CsvTableRepository csvTableRepository;
	private final RowRepository rowRepository;
	private final CellRepository cellRepository;

	@Autowired
	public CsvProcessingServiceImpl(CsvTableRepository csvTableRepository, RowRepository rowRepository,
			CellRepository cellRepository) {
		this.csvTableRepository = csvTableRepository;
		this.rowRepository = rowRepository;
		this.cellRepository = cellRepository;
	}

	public String processCsv(String csvInput) {
		try {
			CsvTable csvTable = parseCsvData(csvInput);
			calculateCsvTable(csvTable);
			return convertToCsvOutput(csvTable);
		} catch (InvalidCsvFormatException | CircularReferenceException | DivideByZeroException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("An unexpected error occurred while processing the CSV data", e);
		}
	}

	public CsvTable parseCsvData(String csvInput) {
		CsvTable csvTable = new CsvTable();
		String[] rows = csvInput.split("\n");

		for (String rowString : rows) {
			Row row = new Row();
			String[] cells = rowString.trim().split(",");

			for (String cellValue : cells) {
				Cell cell = new Cell();
				cell.setValue(cellValue.trim());
				cell.setRow(row);
				row.getCells().add(cell);
			}

			row.setCsvTable(csvTable);
			csvTable.getRows().add(row);
		}

		return csvTable;
	}

	public void calculateCsvTable(CsvTable csvTable) {
		for (Row row : csvTable.getRows()) {
			for (Cell cell : row.getCells()) {
				String cellValue = cell.getValue();

				if (cellValue.startsWith("=")) {
					try {
						String formula = cellValue.substring(1);
						int result = evaluateFormula(formula, csvTable);
						cell.setValue(String.valueOf(result));
					} catch (CircularReferenceException | DivideByZeroException e) {
						throw e;
					} catch (Exception e) {
						throw new InvalidCsvFormatException("Invalid formula in cell: " + cellValue);
					}
				}
			}
		}
	}

	public int evaluateFormula(String formula, CsvTable csvTable) {
		return 42;
	}

	public String convertToCsvOutput(CsvTable csvTable) {
		StringBuilder csvOutput = new StringBuilder();

		for (Row row : csvTable.getRows()) {
			for (Cell cell : row.getCells()) {
				csvOutput.append(cell.getValue()).append(",");
			}
			csvOutput.deleteCharAt(csvOutput.length() - 1);
			csvOutput.append("\n");
		}

		return csvOutput.toString();
	}

}
