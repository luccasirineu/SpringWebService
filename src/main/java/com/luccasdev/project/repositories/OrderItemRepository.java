package com.luccasdev.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccasdev.project.entities.OrderItem;




public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
}