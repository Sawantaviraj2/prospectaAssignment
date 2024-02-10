package com.CSVApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CSVApplication.entity.Row;

public interface RowRepository extends JpaRepository<Row, Long> {

}
