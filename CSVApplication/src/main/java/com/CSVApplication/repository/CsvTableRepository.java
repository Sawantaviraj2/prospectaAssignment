package com.CSVApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CSVApplication.entity.CsvTable;

public interface CsvTableRepository extends JpaRepository<CsvTable, Long> {

}
