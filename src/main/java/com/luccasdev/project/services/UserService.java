package com.luccasdev.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccasdev.project.entities.User;
import com.luccasdev.project.repositories.UserRepository;
import com.luccasdev.project.services.exceptions.ResourceNotFoundException;


@Service // para dizer que essa classe é de serviço, podendo assim outras classes dependerem dessa
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // ele tenta dar o get e caso nao consiga, lancara essa exceção
		
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); // prepara o objeto, sem acessar ao banco de dados
		updateData(entity, obj);
		return repository.save(entity); // agora ele salva no banco de dados
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
