package br.com.redemob.dominio.repositorio.builder;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import br.com.redemob.dominio.modelo.Solicitacao;

public class QueryBuilder {

	public static Example<Solicitacao> makeQuery(Solicitacao solicitacao) {
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues();
		return Example.of(solicitacao, exampleMatcher);
	}

}