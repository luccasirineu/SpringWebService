package com.luccasdev.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccasdev.project.entities.Category;




public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}