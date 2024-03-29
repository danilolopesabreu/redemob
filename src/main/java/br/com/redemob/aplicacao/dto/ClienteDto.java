package br.com.redemob.aplicacao.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteDto {

	private Long id;
	
	@NotBlank(message = "Nome do titular obrigatório.")
	private String nomeCompletoTitular;
	
	@NotBlank(message = "Nome da mãe do titular obrigatório.")
	private String nomeCompletoMaeTitular;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotBlank(message = "CPF Obrigatório.")
	@Size(min = 11, max = 11, message = "CPF deve ter tamanho de 11 caracteres.")
	private String cpf;
	
	@NotBlank(message = "Foto do Rosto obrigatório.")
	private String fotoRosto;
	
	@NotBlank(message = "Foto da Identidade obrigatória.")
	private String identidade;
	
	@NotBlank(message = "Foto Comprovante Residencia obrigatório.")
	private String comprovanteResidencia;

	@NotNull(message = "Municipio é Obrigatório.")
	@Min(value = 1, message = "Numero do Municipio deve ser maior que ou igual à 1")
	private Integer municipio;
	
	@Size(min = 8, max = 20, message = "Senha deve ter no minimo 8 e no maximo 20 caracteres.")
	private String senha;

	@JsonManagedReference 
	private List<SolicitacaoDto> solicitacoes;

	public String getNomeCompletoTitular() {
		return nomeCompletoTitular;
	}

	public void setNomeCompletoTitular(String nomeCompletoTitular) {
		this.nomeCompletoTitular = nomeCompletoTitular;
	}

	public String getNomeCompletoMaeTitular() {
		return nomeCompletoMaeTitular;
	}

	public void setNomeCompletoMaeTitular(String nomeCompletoMaeTitular) {
		this.nomeCompletoMaeTitular = nomeCompletoMaeTitular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFotoRosto() {
		return fotoRosto;
	}

	public void setFotoRosto(String fotoRosto) {
		this.fotoRosto = fotoRosto;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getComprovanteResidencia() {
		return comprovanteResidencia;
	}

	public void setComprovanteResidencia(String comprovanteResidencia) {
		this.comprovanteResidencia = comprovanteResidencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<SolicitacaoDto> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoDto> solicitacoesDto) {
		this.solicitacoes = solicitacoesDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}

}
