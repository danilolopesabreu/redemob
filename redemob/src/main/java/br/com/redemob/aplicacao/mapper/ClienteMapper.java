package br.com.redemob.aplicacao.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.redemob.aplicacao.dto.ClienteDto;
import br.com.redemob.aplicacao.dto.SolicitacaoDto;
import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.modelo.Solicitacao;

@Mapper(componentModel = "spring") 
public interface ClienteMapper {
	
	Cliente INSTANCE = Mappers.getMapper(Cliente.class);
	
	public ClienteDto clienteToClienteDto(Cliente Cliente);
	
	@Mapping(target = "dataNascimento", dateFormat = "dd/MM/yyyy")
	public Cliente clienteDtoToCliente(ClienteDto Cliente);
	
	public List<ClienteDto> clientesToClientesDto(List<Cliente> Clientes);
	
	@InheritInverseConfiguration
	public SolicitacaoDto toSolicitacaoDto(Solicitacao solicitacao); 
}