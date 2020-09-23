package br.com.infnet.apiclientes.testes;

import br.com.infnet.apiclientes.controller.ClienteController;

public class ClienteTeste {

	public static void main(String[] args) {
		
		ClienteController controle = new ClienteController();
		
		System.out.println(controle.ClienteLista());

	}
}