package br.com.redemob.dominio.modelo;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "solicitacao")
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cliente_id", nullable=false)
	private Cliente cliente;

	@Column(name = "data_solicitacao", nullable = false)
	@CreationTimestamp
	private Date dataSolicitacao;
	
	@Column(name = "data_avaliacao", nullable = true)
	private Date dataAvaliacao;

	@Column(name = "aprovado", nullable = true)
	private Boolean aprovado;

	public Solicitacao(Cliente cliente, Date dataSolicitacao) {
		super();
		this.cliente = cliente;
		this.dataSolicitacao = dataSolicitacao;
	}
	
	public Solicitacao(
			Long idCliente, String cpf, String nomeCompletoTitular, 
			String nomeCompletoMaeTitular, Date dataNascimento,	int municipio,
			Long idSolicitacao, Date dataSolicitacao, Date dataAvaliacao, Boolean aprovado) {
		super();
		
		this.cliente = new Cliente(idCliente, cpf, nomeCompletoTitular, nomeCompletoMaeTitular, dataNascimento, municipio);
		this.id = idSolicitacao;
		this.dataSolicitacao = dataSolicitacao;
		this.dataAvaliacao = dataAvaliacao;
		this.aprovado = aprovado;
	}
	
	public Solicitacao(Long id, Date dataSolicitacao, Date dataAvaliacao, Boolean aprovado) {
		super();
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
		this.dataAvaliacao = dataAvaliacao;
		this.aprovado = aprovado;
	}

	public Solicitacao(Cliente cliente) {
		super();
		this.cliente = cliente;
	}
	
	public Solicitacao(Boolean aprovado) {
		super();
		this.aprovado = aprovado;
	}
	
	public Solicitacao(Date dataSolicitacao) {
		super();
		this.dataSolicitacao = dataSolicitacao;
	}

	public Solicitacao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	@Override
	public int hashCode() {
		return Objects.hash(cliente, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id);
	}

}
