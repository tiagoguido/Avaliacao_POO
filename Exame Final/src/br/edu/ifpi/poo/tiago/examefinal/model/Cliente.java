package br.edu.ifpi.poo.tiago.examefinal.model;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery (name="Cliente.buscarTodos", query="select c from Cliente c")
})
public class Cliente {
	@Id
	@GeneratedValue 
	private Long codigo;
	private String nome;
	@Embedded
	private Dados dados;

	public Cliente(Long codigo, String nome, Dados dados) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dados = dados;
	}

	public Cliente(String nome, Dados dados) {
		super();
		this.nome = nome;
		this.dados = dados;
	}

	public Cliente() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Dados getDados() {
		return dados;
	}

	public void setEndereco(Dados dados) {
		this.dados = dados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco="
				+ dados + "]";
	}

}
