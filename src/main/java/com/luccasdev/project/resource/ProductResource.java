package com.luccasdev.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luccasdev.project.entities.Product;
import com.luccasdev.project.services.ProductService;

@RestController // serve para dizer que esta é uma classe controller
@RequestMapping(value = "/products") // serve para dizer qual vai ser o nome do endpoint
public class ProductResource {

	@Autowired
	private ProductService service;
	
@GetMapping // serve para dizer que este metodo é um GET
	public ResponseEntity<List<Product>> findAll(){ // ResponseEntity que retorna a requisição web
	List<Product> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}

@GetMapping(value = "/{id}")
public ResponseEntity<Product>findById(@PathVariable Long id){
	Product obj = service.findById(id);
	return ResponseEntity.ok().body(obj);

}
}
