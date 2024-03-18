package com.luccasdev.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccasdev.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
