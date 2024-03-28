package br.com.redemob.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.redemob.dominio.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

	@Query(
		"SELECT cliente FROM br.com.redemob.dominio.modelo.Cliente cliente "+
		"JOIN FETCH cliente.solicitacoes solicitacoes"
	)
	public List<Cliente> listarClientes();
	
	@Query(
		"SELECT cliente FROM br.com.redemob.dominio.modelo.Cliente cliente "+
		"JOIN FETCH cliente.solicitacoes solicitacoes " +
		"WHERE solicitacoes.dataAvaliacao is null"
	)
	public List<Cliente> listarClientesComSolicitacaoSemAvaliacao();

	@Query(
			"SELECT cliente FROM br.com.redemob.dominio.modelo.Cliente cliente "+
			"JOIN FETCH cliente.solicitacoes solicitacoes "+
			"WHERE cliente.cpf = :cpf AND cliente.senha = :senha"
		)
	public Cliente findByCpfAndSenha(String cpf, String senha);
	
}