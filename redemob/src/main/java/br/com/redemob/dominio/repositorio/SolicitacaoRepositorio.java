package br.com.redemob.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.modelo.Solicitacao;

@Repository
public interface SolicitacaoRepositorio extends JpaRepository<Solicitacao, Long> {

	@Query(
		"SELECT solicitacao FROM br.com.redemob.dominio.modelo.Solicitacao solicitacao " +
		"JOIN FETCH solicitacao.cliente cliente " +
		"WHERE solicitacao.dataAvaliacao = null"
	)
	public List<Solicitacao> listarSolicitacoesParaVerificacao();
	
	public int countByCliente(Cliente cliente);
	
}