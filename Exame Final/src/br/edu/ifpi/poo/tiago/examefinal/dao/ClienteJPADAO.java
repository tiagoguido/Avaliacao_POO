package br.edu.ifpi.poo.tiago.examefinal.dao;

import java.util.List;

import br.edu.ifpi.poo.tiago.examefinal.model.Cliente;

public class ClienteJPADAO extends GenericJPADAO<Cliente> implements ClienteDAO<Cliente>{
	public ClienteJPADAO(){
		this.classe = Cliente.class;
	}
	@Override
	public List<Cliente> listarTodos(){
		return em.createNamedQuery("Cliente.buscarTodos").getResultList();
	}
}
