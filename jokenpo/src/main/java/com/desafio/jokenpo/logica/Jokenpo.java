package com.desafio.jokenpo.logica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.desafio.jokenpo.exception.JogadorException;
import com.desafio.jokenpo.type.JogadasEnum;
import com.desafio.jokenpo.type.Jogador;

@Component("jokenpo")
public class Jokenpo {
	
	
	List<Jogador> jogadores = new ArrayList<Jogador>();
	
	/**
	 * @return List<Jogador> com jogadores vencedores caso haja
	 */
	public List<Jogador> executarJogo(){
		
		List<Jogador> vencedores = new ArrayList<Jogador>();
		
		boolean ehVencidoPorAlguem = false;
		boolean venceAlguem = false;
		
		for(Jogador jogador : jogadores) {
			
			for(Jogador adversario : jogadores) {
				
				if(!jogador.getNome().equals(adversario.getNome())) {
					
					JogadasEnum jogadaJogador = obterJogadaPorNome(jogador.getJogada());
					JogadasEnum jogadaAdversario = obterJogadaPorNome(adversario.getJogada());
					
					JogadasEnum jogadaVencedora = jogadaVencedora(jogadaJogador, jogadaAdversario);
					
					if(jogadaVencedora != null) {
						
						if(jogadaVencedora == jogadaJogador) {
							venceAlguem = true;
						}else {
							ehVencidoPorAlguem = true;
						}
					}
				}	
			}
			
			if(venceAlguem && !ehVencidoPorAlguem) {
				vencedores.add(jogador);
			}
			ehVencidoPorAlguem = false;
			venceAlguem = false;			
		}
		
		
		return vencedores;
	}
	
	
	public void adicionaJogador(Jogador jogador){
		
		JogadasEnum jogada = obterJogadaPorNome(jogador.getJogada());
		
		if(jogador.getNome() == null || jogador.getNome().isEmpty() || jogador.getJogada() == null || jogador.getJogada().isEmpty()) {
			throw new JogadorException("Nome e jogada do jogador devem estar obrigatoriamente preenchidos.");
		}
		
		if(jogada == null) {
			throw new JogadorException("Jogada inválida.");
		}
		
		for(Jogador j : jogadores) {
				
			if(j.getNome().equals(jogador.getNome())){
				throw new JogadorException("Nome do jogador já cadastrado, exclua-o para fazer uma nova jogada desse jogador.");
			}
			
			
		}
		
		jogadores.add(jogador);
		
	}
	
	
	public JogadasEnum obterJogadaPorNome(String nome) {
		
		for(JogadasEnum jogada : JogadasEnum.values()) {
			
			if(nome != null && nome.toUpperCase().equals(jogada.name())) {
				
				return jogada;
			}
		}
		
		return null;
	}
	
	
	public JogadasEnum jogadaVencedora(JogadasEnum jogada1, JogadasEnum jogada2) {
		
		
		boolean jogada1Vence = false;
		boolean jogada2Vence = false;
		
		for(String nomeJogada : jogada1.getJogadasQueVence()) {
			if(nomeJogada.toUpperCase().equals(jogada2.name())) {
				jogada1Vence = true;
			}
		}
		
		for(String nomeJogada : jogada2.getJogadasQueVence()) {
			if(nomeJogada.toUpperCase().equals(jogada1.name())) {
				jogada2Vence = true;
			}
		}
		
		if(jogada1Vence && !jogada2Vence) {
			return jogada1;
		}else if(jogada2Vence && !jogada1Vence) {
			return jogada2;
		}
		
		return null;
	}


	public boolean excluiJogador(String nome) {
		
		int index = 0;
		boolean removido = false;
		for(Jogador jogador : jogadores) {
			
			if(jogador.getNome().equals(nome)) {
				removido = true;
				break;
			}
			
			index++;
		}
		
		if(removido){
			jogadores.remove(index);
		}
		return removido;
	}
	
	public Jogador buscaJogador(String nome) {
		
		for(Jogador jogador : jogadores) {
			
			if(jogador.getNome().equals(nome)) {
				return jogador;
			}
		}
		
		return null;
	}		

}
