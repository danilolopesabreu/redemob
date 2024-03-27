package br.com.redemob.aplicacao.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class SolicitacaoDto {

	private int id;
	
	@JsonBackReference
	private ClienteDto clienteDto;
	
	private Date dataSolicitacao;
	private Date dataAvaliacao;
	private Boolean aprovado;
	
	public SolicitacaoDto(Date dataSolicitacao) {
		super();
		this.dataSolicitacao = dataSolicitacao;
	}

	public SolicitacaoDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
