package br.com.redemob.dominio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.modelo.Solicitacao;
import br.com.redemob.dominio.repositorio.ClienteRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Cliente create(Cliente cliente) {
		cliente.setSolicitacoes(Arrays.asList(new Solicitacao(cliente)));
		return this.clienteRepositorio.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.clienteRepositorio.listarClientes();
	}
	
	public List<Cliente> listarClientesComSolicitacaoSemAvaliacao(){
		return this.clienteRepositorio.listarClientesComSolicitacaoSemAvaliacao();
	}
	
}
