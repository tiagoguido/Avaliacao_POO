package br.edu.ifpi.poo.tiago.examefinal.model;

import javax.persistence.Embeddable;

@Embeddable
public class Dados {
	public String cpf;
	public String endereco;
	public String telefone;
	public String profissao;
	public String idade;

	public Dados() {
	}

	public Dados(String cpf, String endereco, String telefone, String profissao,
			String idade) {
		super();
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.profissao = profissao;
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfisao(String profisao) {
		this.profissao = profisao;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Dados [cpf=" + cpf + ", endereco=" + endereco + ", telefone="
				+ telefone + ", profisao=" + profissao + ", idade=" + idade
				+ "]";
	}

	
}