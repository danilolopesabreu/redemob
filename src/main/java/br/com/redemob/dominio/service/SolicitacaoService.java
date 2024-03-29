package br.com.redemob.dominio.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	@Autowired
	private ClienteService clienteService;
	
	public Solicitacao create(Solicitacao solicitacao) {
		return this.solicitacaoRepositorio.save(solicitacao);
	}
	
	private Integer contarSolicitacoesPelaSituacao(List<Solicitacao> solicitacoes, Boolean situacao) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		
		solicitacoes.stream()
					.filter(solicitacao -> solicitacao.getAprovado() == situacao)
					.forEach(solicitacao -> {
						atomicInteger.getAndIncrement();
					});
		
		return atomicInteger.get();
	}
	
	public Solicitacao novaSolicitacaoCliente(Long idCliente) {
		
		var cliente = this.clienteService.consultarPorId(idCliente);
		var solicitacoes = cliente.getSolicitacoes();
		
		Integer qtdSolicitacoes = this.contarSolicitacoesPelaSituacao(solicitacoes, null);
		
		if(qtdSolicitacoes >= 1)
			throw new RuntimeException("Cliente com solicitação Aberta.");
		
		qtdSolicitacoes = this.contarSolicitacoesPelaSituacao(solicitacoes, false);
		
		if(qtdSolicitacoes >= 2)
			throw new RuntimeException("Cliente com duas solicitações Recusadas.");
		
		qtdSolicitacoes = this.contarSolicitacoesPelaSituacao(solicitacoes, true);
		
		if(qtdSolicitacoes >= 1)
			throw new RuntimeException("Cliente já possui solicitação Aprovada.");
		
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
