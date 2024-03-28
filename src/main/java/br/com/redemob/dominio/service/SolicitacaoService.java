package br.com.redemob.dominio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.modelo.Solicitacao;
import br.com.redemob.dominio.repositorio.SolicitacaoRepositorio;
import jakarta.transaction.Transactional;

@Service
public class SolicitacaoService {
	
	@Autowired
	private SolicitacaoRepositorio solicitacaoRepositorio;
	
	public Solicitacao create(Solicitacao solicitacao) {
		return this.solicitacaoRepositorio.save(solicitacao);
	}
	
	public Solicitacao novaSolicitacaoCliente(Long idCliente) {
		Solicitacao solicitacao = new Solicitacao(new Cliente(idCliente));
		return this.solicitacaoRepositorio.save(solicitacao);
	}

	public List<Solicitacao> listarSolicitacoesParaVerificacao() {
		return this.solicitacaoRepositorio.listarSolicitacoesParaVerificacao();
	}

	@Transactional
	public void alterarSituacaoSolicitacao(Solicitacao solicitacao) {
		this.solicitacaoRepositorio.alterarSituacaoSolicitacao(solicitacao.getId(), new Date(), solicitacao.getAprovado());
	}
	
	
	
}
