package com.prospectaapplication1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospectaapplication1.entity.ApiCategory;

public interface ApiCategoryRepository extends JpaRepository<ApiCategory, String> {

}
