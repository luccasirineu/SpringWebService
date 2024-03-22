package com.luccasdev.project.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luccasdev.project.entities.User;
import com.luccasdev.project.services.UserService;

@RestController // serve para dizer que esta é uma classe controller
@RequestMapping(value = "/users") // serve para dizer qual vai ser o nome do endpoint
public class UserResource {

	@Autowired
	private UserService service;
	
@GetMapping // serve para dizer que este metodo é um GET e retorna algo do banco de dados
	public ResponseEntity<List<User>> findAll(){ // ResponseEntity que retorna a requisição web
	List<User> list = service.findAll();
	return ResponseEntity.ok().body(list);
	}

@GetMapping(value = "/{id}")
public ResponseEntity<User>findById(@PathVariable Long id){
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);

}

@PostMapping // para postar algo no banco de dados
public ResponseEntity<User> insert(@RequestBody User obj){ // RequestBody serve para o json fzr a deserialização do User
	obj = service.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // convertendo o obj em uri para fzr os post
	return ResponseEntity.created(uri).body(obj);
}
}
