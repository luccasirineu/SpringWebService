package com.luccasdev.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luccasdev.project.entities.User;
import com.luccasdev.project.repositories.UserRepository;

@Configuration // para dizer que isso é uma classe de configuração
@Profile("test") // para dizer que o perfil que esta rodando isso é o perfil "teste" que esta em resources
public class TestConfig implements CommandLineRunner { // implementa uma interface que tem um metodo que sera iniciado tudo o que estiver dentro dele ao rodar o programa


	@Autowired // serve para fzr a injecao de independencia de forma automatica
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1, u2)); // serve para salvar no banco de dados
	}
	
}
