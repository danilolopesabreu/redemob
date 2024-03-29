package br.com.redemob.dominio.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Login {
	
	@NotBlank(message = "CPF é Obrigatório.")
	@Size(min = 11, max = 11, message = "CPF deve ter tamanho de 11 caracteres.")
	private String cpf;
	
	@NotBlank(message = "Senha é Obrigatória.")
	@Size(min = 8, max = 20, message = "Senha deve ter no minimo 8 e no maximo 20 caracteres.")
	private String senha;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
