package br.com.redemob.dominio.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.modelo.Solicitacao;

@Repository
public interface SolicitacaoRepositorio extends JpaRepository<Solicitacao, Long> {

	@Query(
		"SELECT new br.com.redemob.dominio.modelo.Solicitacao("
		+ "cliente.id, cliente.cpf, cliente.nomeCompletoTitular, cliente.nomeCompletoMaeTitular, cliente.dataNascimento, cliente.municipio, "
		+ "solicitacao.id, solicitacao.dataSolicitacao, solicitacao.dataAvaliacao, solicitacao.aprovado) "
		+ "FROM br.com.redemob.dominio.modelo.Solicitacao solicitacao " 
		+ "JOIN  solicitacao.cliente cliente "
		+ "WHERE solicitacao.dataAvaliacao is null"
	)
	public List<Solicitacao> listarSolicitacoesParaVerificacao();
	
	public int countByCliente(Cliente cliente);

	@Modifying
	@Query("UPDATE br.com.redemob.dominio.modelo.Solicitacao s SET "
			+ "s.dataAvaliacao = :dataAvaliacao, s.aprovado = :aprovado "
			+ "WHERE s.id = :id")
	public void alterarSituacaoSolicitacao(
			@Param(value = "id") Long id, 
			@Param(value = "dataAvaliacao") Date dataAvaliacao,
			@Param(value = "aprovado") Boolean aprovado);
	
	public Integer countByClienteIdAndAprovadoIs(Long clienteId, Boolean aprovado);
	
}