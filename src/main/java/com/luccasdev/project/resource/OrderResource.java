package com.luccasdev.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luccasdev.project.entities.Order;
import com.luccasdev.project.services.OrderService;

@RestController // serve para dizer que esta é uma classe controller
@RequestMapping(value = "/orders") // serve para dizer qual vai ser o nome do endpoint
public class OrderResource {

	@Autowired
	private OrderService service;
	
@GetMapping // serve para dizer que este metodo é um GET
	public ResponseEntity<List<Order>> findAll(){ // ResponseEntity que retorna a requisição web
	List<Order> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}

@GetMapping(value = "/{id}")
public ResponseEntity<Order>findById(@PathVariable Long id){
	Order obj = service.findById(id);
	return ResponseEntity.ok().body(obj);

}
}
