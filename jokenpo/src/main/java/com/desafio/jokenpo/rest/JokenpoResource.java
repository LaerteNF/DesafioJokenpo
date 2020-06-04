package com.desafio.jokenpo.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.jokenpo.logica.Jokenpo;
import com.desafio.jokenpo.type.Jogador;

@RestController
@RequestMapping("jokenpo")
@SuppressWarnings("rawtypes")
public class JokenpoResource {
	
	@Autowired
	private Jokenpo jokenpo;
	
	@PostMapping("/jogador")
	public ResponseEntity adicionarJogadorJogada(@RequestBody final Jogador jogador) {
		
		jokenpo.adicionaJogador(jogador);
		return ResponseEntity.ok("Jogador e jogada adicionados com sucesso");
	}
	
	
	@GetMapping("/jogar")
	public ResponseEntity jogar() {
		
		String retorno = "Vencedores: ";
		List<Jogador> vencedores =  jokenpo.executarJogo();
		
		if(vencedores.isEmpty()) {
			retorno = "Sem vencedores.";
		}
		
		for(Jogador jogador : vencedores) {
			
			retorno = retorno.concat(jogador.getNome() + " ");	
		}
		
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping("/jogador/{nome}")
	public ResponseEntity consultaJogador(@PathVariable String nome) {
		
			
		Jogador jogador  = jokenpo.buscaJogador(nome);
		
		if(jogador != null) {
			return ResponseEntity.ok("Jogador localizado: " + jogador.getNome() + " jogada: " + jogador.getJogada());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/jogador/{nome}")
	public ResponseEntity excluirJogador(@PathVariable String nome) {
		
		boolean excluido = jokenpo.excluiJogador(nome);
		if(excluido){
			return ResponseEntity.ok("Jogador " + nome + " excluido com sucesso.");
		}else{
			return ResponseEntity.notFound().build();
		}
	}

}
