package com.luccasdev.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccasdev.project.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	
}