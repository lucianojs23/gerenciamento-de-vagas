package com.sistemavagas.gerenciamentoVagas.exceptions;

public class UserFoundException extends RuntimeException {
	public UserFoundException() {
		super("Usuário já existe");  // super() chama o construtor da classe pai	
}
}
