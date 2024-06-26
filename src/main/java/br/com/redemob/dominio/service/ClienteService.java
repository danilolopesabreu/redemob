package br.com.redemob.dominio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.redemob.aplicacao.exception.NotFoundException;
import br.com.redemob.aplicacao.exception.RegistroExisteException;
import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.modelo.Solicitacao;
import br.com.redemob.dominio.repositorio.ClienteRepositorio;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Cliente cadastrar(Cliente cliente) {
		cliente.setSolicitacoes(Arrays.asList(new Solicitacao(cliente)));
		Cliente novoCliente;
		try {
			novoCliente = this.clienteRepositorio.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new RegistroExisteException("CPF já está cadastrado"); 
		}
		return novoCliente;
	}
	
	public Cliente consultarPorId(Long id) {
		return this.clienteRepositorio.findById(id).orElseThrow(
				() -> new NotFoundException("Cliente não encontrado"));
	}
	
	@Transactional
	public List<Cliente> listarClientes(){
		return this.clienteRepositorio.listarClientes();
	}
	
	@Transactional
	public List<Cliente> listarClientesComSolicitacaoSemAvaliacao(){
		return this.clienteRepositorio.listarClientesComSolicitacaoSemAvaliacao();
	}
	
	@Transactional
	public Cliente consultarPorCpfEsenha(String cpf, String senha) {
		var cliente = this.clienteRepositorio.findByCpfAndSenha(cpf, senha)
				.orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
		return cliente;
	}
	
}
