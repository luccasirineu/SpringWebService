package com.luccasdev.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccasdev.project.entities.Order;
import com.luccasdev.project.repositories.OrderRepository;


@Service // para dizer que essa classe é de serviço, podendo assim outras classes dependerem dessa
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}