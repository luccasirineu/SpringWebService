package com.luccasdev.project.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luccasdev.project.entities.User;

@RestController // serve para dizer que esta é uma classe controller
@RequestMapping(value = "/home") // serve para dizer qual vai ser o nome do endpoint
public class UserResource {

@GetMapping // serve para dizer que este metodo é um GET
	public ResponseEntity<User> findAll(){ // ResponseEntity que retorna a requisição web
		User u = new User(1L, "Luccas", "lucasda@gmail.com", "119321312", "pass123" );
		return ResponseEntity.ok().body(u);
	}
}
