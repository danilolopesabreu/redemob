package br.com.redemob.aplicacao.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.dominio.modelo.Solicitacao;
import br.com.redemob.dominio.service.SolicitacaoService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoResource {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@PostMapping
	public Solicitacao cadastrarSolicitacao(@RequestBody Solicitacao solicitacao) {
		this.solicitacaoService.create(solicitacao);
		return solicitacao;
	}
	
	@PostMapping("/cliente/{id}")
	public Solicitacao cadastrarNovaSolicitacao(@PathVariable("id") Long idCliente) {
		return this.solicitacaoService.novaSolicitacaoCliente(idCliente);
	}
	
	@GetMapping
	public List<Solicitacao> listarSolicitacoesParaVerificacao() {
		return this.solicitacaoService.listarSolicitacoesParaVerificacao();
	}
	
	
}
