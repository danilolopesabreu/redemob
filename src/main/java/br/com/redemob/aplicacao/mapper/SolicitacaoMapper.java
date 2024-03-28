package br.com.redemob.aplicacao.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.redemob.aplicacao.dto.SolicitacaoDto;
import br.com.redemob.dominio.modelo.Solicitacao;

@Mapper(componentModel = "spring") 
public interface SolicitacaoMapper {
	
	Solicitacao INSTANCE = Mappers.getMapper(Solicitacao.class);
	
	public SolicitacaoDto solicitacaoToSolicitacaoDto(Solicitacao Solicitacao);
	
	@Mapping(target = "dataSolicitacao", dateFormat = "dd/MM/yyyy")
	@Mapping(target = "dataAvaliacao", dateFormat = "dd/MM/yyyy")
	public Solicitacao solicitacaoDtoToSolicitacao(SolicitacaoDto Solicitacao);
	
	@InheritInverseConfiguration
	public SolicitacaoDto toSolicitacaoDto(Solicitacao solicitacao); 
}