package br.com.redemob.aplicacao.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ClienteDto {

	private Long id;
	private String nomeCompletoTitular;
	private String nomeCompletoMaeTitular;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	private String cpf;
	private String fotoRosto;
	private String identidade;
	private String comprovanteResidencia;
	private int municipio;
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

	public int getMunicipio() {
		return municipio;
	}

	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}

}
