package br.com.redemob.aplicacao.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.aplicacao.dto.SolicitacaoDto;
import br.com.redemob.aplicacao.mapper.SolicitacaoMapper;
import br.com.redemob.dominio.modelo.Solicitacao;
import br.com.redemob.dominio.service.SolicitacaoService;

@CrossOrigin()
@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoResource {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@Autowired
	private SolicitacaoMapper solicitacaoMapper;
	
	@PostMapping("/cliente/{id}")
	public Solicitacao cadastrarNovaSolicitacao(@PathVariable("id") Long idCliente) {
		return this.solicitacaoService.novaSolicitacaoCliente(idCliente);
	}
	
	@GetMapping
	public List<Solicitacao> listarSolicitacoesParaVerificacao() {
		return this.solicitacaoService.listarSolicitacoesParaVerificacao();
	}
	
	@PostMapping("/avaliacao")
	public void alterarSituacaoSolicitacao(@RequestBody SolicitacaoDto solicitacaoDto) {
		Solicitacao solicitacao = this.solicitacaoMapper.solicitacaoDtoToSolicitacao(solicitacaoDto);
		this.solicitacaoService.alterarSituacaoSolicitacao(solicitacao);
	}
	
	
}
