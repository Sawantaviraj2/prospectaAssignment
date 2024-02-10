package com.CSVApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CSVApplication.entity.Cell;

public interface CellRepository extends JpaRepository<Cell, Long> {

}
