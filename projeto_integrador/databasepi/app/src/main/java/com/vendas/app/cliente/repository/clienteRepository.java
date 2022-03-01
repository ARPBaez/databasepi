package com.vendas.app.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vendas.app.cliente.models.cliente;

public interface clienteRepository extends CrudRepository<cliente, Long> {

	// criado para a busca de clientes por id ou chave primária
	cliente findById(long id);

	// criado para a busca de clientes por nome
	cliente findByNome(String nome);

	// Busca para vários nomes de clientes
	@Query(value = "select u from cliente u where u.nome like %?1%")
	List<cliente> findByNomes(String nome);

}