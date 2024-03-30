package br.com.redemob.dominio.modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_completo_titular", nullable = false)
	private String nomeCompletoTitular;

	@Column(name = "nome_completo_mae_titular", nullable = false)
	private String nomeCompletoMaeTitular;

	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

	@Column(name = "foto_rosto", nullable = false)
	@Lob
	private String fotoRosto;

	@Column(name = "identidade", nullable = false)
	@Lob
	private String identidade;

	@Column(name = "comprovante_residencia", nullable = false)
	@Lob
	private String comprovanteResidencia;

	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "municipio", nullable = false)
	private int municipio;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Solicitacao> solicitacoes;

	public Cliente() {
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String cpf, String senha, String nomeCompletoTitular, String nomeCompletoMaeTitular, Date dataNascimento,
			String fotoRosto, String identidade, String comprovanteResidencia, int municipio) {
		super();
		this.nomeCompletoTitular = nomeCompletoTitular;
		this.nomeCompletoMaeTitular = nomeCompletoMaeTitular;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.fotoRosto = fotoRosto;
		this.identidade = identidade;
		this.comprovanteResidencia = comprovanteResidencia;
		this.senha = senha;
		this.municipio = municipio;
	}
	
	public Cliente(Long id, String cpf, String nomeCompletoTitular, String nomeCompletoMaeTitular, Date dataNascimento, int municipio) {
		super();
		this.id = id;
		this.nomeCompletoTitular = nomeCompletoTitular;
		this.nomeCompletoMaeTitular = nomeCompletoMaeTitular;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.municipio = municipio;
	}

	public Cliente(Long idCliente) {
		this.id = idCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public int getMunicipio() {
		return municipio;
	}

	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeCompletoTitular=" + nomeCompletoTitular + ", cpf=" + cpf + "]";
	}
	
}
