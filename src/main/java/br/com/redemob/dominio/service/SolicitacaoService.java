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
	
	@Autowired
	private ClienteService clienteService;
	
	public Solicitacao create(Solicitacao solicitacao) {
		return this.solicitacaoRepositorio.save(solicitacao);
	}
	
	public Solicitacao novaSolicitacaoCliente(Long idCliente) {
		
		this.clienteService.consultarPorId(idCliente);//verifica se cliente existe
		
		Integer qtdAguardando = this.solicitacaoRepositorio.countByClienteIdAndAprovadoIs(idCliente, null);
		
		if(qtdAguardando >= 1)
			throw new RuntimeException("Cliente com solicitação Aberta.");
		
		Integer qtdReprovacao = this.solicitacaoRepositorio.countByClienteIdAndAprovadoIs(idCliente, false);
		
		if(qtdReprovacao >= 2)
			throw new RuntimeException("Cliente com duas solicitações Recusadas.");
		
		Integer qtdAprovacao = this.solicitacaoRepositorio.countByClienteIdAndAprovadoIs(idCliente, true);
		
		if(qtdAprovacao >= 1)
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
