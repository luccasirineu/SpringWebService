package com.luccasdev.project.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{//exceção que o compilador nao obriga a tratar

	private static final long serialVersionUID = 1L; 
	
	public ResourceNotFoundException(Object id) {
		super("Object not found. Id: "+ id);
	}

}
