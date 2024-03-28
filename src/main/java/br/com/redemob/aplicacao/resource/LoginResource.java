package br.com.redemob.aplicacao.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.aplicacao.dto.ClienteDto;
import br.com.redemob.aplicacao.mapper.ClienteMapper;
import br.com.redemob.dominio.modelo.Login;
import br.com.redemob.dominio.service.ClienteService;

@CrossOrigin()
@RestController
@RequestMapping("/acesso-restrito")
public class LoginResource {

	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/login")
	public ClienteDto login(@RequestBody Login login) {
		return this.clienteMapper.clienteToClienteDto(
				this.clienteService.consultarPorCpfEsenha(login.getCpf(), login.getSenha()));
	}
	
}
