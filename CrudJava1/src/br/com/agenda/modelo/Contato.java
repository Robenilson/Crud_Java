package br.com.agenda.modelo;

import java.util.Date;

public class Contato {
	
	private  int id;
	private String  nome;
	private int idade;
	private Date dataCadastrao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCadastrao() {
		return dataCadastrao;
	}
	public void setDataCadastrao(Date dataCadastrao) {
		this.dataCadastrao = dataCadastrao;
	}
	@Override
	public String toString() {
		return "\n id:" + id + ", Nome:" + nome + ", Idade:" + idade + ", Data cadastrao:" + dataCadastrao + " \n";
	}
	
	

}
