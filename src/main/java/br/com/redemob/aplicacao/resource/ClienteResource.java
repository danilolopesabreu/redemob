package br.com.redemob.aplicacao.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.redemob.aplicacao.dto.ClienteDto;
import br.com.redemob.aplicacao.mapper.ClienteMapper;
import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.service.ClienteService;
import jakarta.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ClienteDto cadastrarCliente(@Valid @RequestBody ClienteDto clienteDto) {
		Cliente cliente = this.clienteMapper.clienteDtoToCliente(clienteDto);
		return this.clienteMapper.clienteToClienteDto(this.clienteService.cadastrar(cliente));
	}
	
	@GetMapping
	public List<ClienteDto> listarClientes(){
		return this.clienteMapper.clientesToClientesDto(
					this.clienteService.listarClientes()
				); 
	}
	
	@GetMapping("/semavaliacao")
	public List<ClienteDto> listarClientesComSolicitacaoSemAvaliacao(){
		return this.clienteMapper.clientesToClientesDto(
					this.clienteService.listarClientesComSolicitacaoSemAvaliacao()
				); 
	}
	
	@PostMapping("/upload-imagem")
	public void cadastrarImagemCliente(@RequestParam("image") MultipartFile file) {
	}
	
}
