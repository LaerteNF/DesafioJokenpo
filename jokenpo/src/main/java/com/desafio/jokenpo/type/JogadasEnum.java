package com.desafio.jokenpo.type;

import java.util.Arrays;
import java.util.List;

public enum JogadasEnum{
	
	SPOCK("Spock", new String[] {"Tesoura", "Pedra"}), 
	TESOURA("Tesoura", new String[] {"Papel", "Lagarto"}),
	PAPEL("Papel", new String[] {"Spock", "Pedra"}),
	PEDRA("Pedra", new String[] {"Tesoura", "Lagarto"}),
	LAGARTO("Lagarto", new String[] {"Spock", "Papel"});
	
	private String nome;
	private List<String> jogadasQueVence;
	
	JogadasEnum(String nome, String[] joagadasQueVence){
		
		this.jogadasQueVence = Arrays.asList(joagadasQueVence);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getJogadasQueVence() {
		return jogadasQueVence;
	}

	public void setJogadasQueVence(List<String> jogadasQueVence) {
		this.jogadasQueVence = jogadasQueVence;
	}

}
