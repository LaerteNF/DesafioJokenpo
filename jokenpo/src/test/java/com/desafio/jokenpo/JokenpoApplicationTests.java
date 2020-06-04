package com.desafio.jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.jokenpo.exception.JogadorException;
import com.desafio.jokenpo.logica.Jokenpo;
import com.desafio.jokenpo.type.Jogador;

@SpringBootTest
class JokenpoApplicationTests {
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void vitoriaJogador1() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("Pedra");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("tesoura");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assertEquals(vencedores.get(0).getNome(), "Jogador1");	
		
	}
	
	@Test
	void vitoriaJogador3() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("spock");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("pedra");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("papel");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assertEquals(vencedores.get(0).getNome(), "Jogador3");	
		
	}
	
	@Test
	void SemVencedores() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("spock");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("lagarto");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assert(vencedores.isEmpty());	
		
	}
	
	@Test
	void vitoriaJogador2() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("lagarto");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("papel");
		Jogador jogador4 = new Jogador();
		jogador4.setNome("Jogador4");
		jogador4.setJogada("lagarto");
		Jogador jogador5 = new Jogador();
		jogador5.setNome("Jogador5");
		jogador5.setJogada("papel");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		jokenpo.adicionaJogador(jogador4);
		jokenpo.adicionaJogador(jogador5);
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assertEquals(vencedores.get(0).getNome(), "Jogador2");	
		
	}
	
	@Test
	void vitoriaJogador4() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("tesoura");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador4");
		jogador2.setJogada("Pedra");

		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assertEquals(vencedores.get(0).getNome(), "Jogador4");	
		
	}
	
	@Test
	void vitoriaJogador1e3() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("pedra");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("pedra");
		Jogador jogador4 = new Jogador();
		jogador4.setNome("Jogador4");
		jogador4.setJogada("lagarto");
		Jogador jogador5 = new Jogador();
		jogador5.setNome("Jogador5");
		jogador5.setJogada("tesoura");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		jokenpo.adicionaJogador(jogador4);
		jokenpo.adicionaJogador(jogador5);
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assertEquals(vencedores.get(0).getNome(), "Jogador1");	
		assertEquals(vencedores.get(1).getNome(), "Jogador3");	
		assertEquals(vencedores.size(), 2);
		
	}
	
	@Test
	void vitoriaJogador1ExclusaoJogador3() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("pedra");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("pedra");
		Jogador jogador4 = new Jogador();
		jogador4.setNome("Jogador4");
		jogador4.setJogada("lagarto");
		Jogador jogador5 = new Jogador();
		jogador5.setNome("Jogador5");
		jogador5.setJogada("tesoura");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		jokenpo.adicionaJogador(jogador4);
		jokenpo.adicionaJogador(jogador5);
		assert(jokenpo.excluiJogador("Jogador3"));
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assertEquals(vencedores.get(0).getNome(), "Jogador1");	
		assertEquals(vencedores.size(), 1);
		
	}	
	

	@Test
	void semVencedores2() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("pedra");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("papel");
		Jogador jogador4 = new Jogador();
		jogador4.setNome("Jogador4");
		jogador4.setJogada("spock");
		Jogador jogador5 = new Jogador();
		jogador5.setNome("Jogador5");
		jogador5.setJogada("lagarto");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		jokenpo.adicionaJogador(jogador4);
		jokenpo.adicionaJogador(jogador5);
		jokenpo.excluiJogador("Jogador3");
		
		List<Jogador> vencedores = jokenpo.executarJogo();
		assert(vencedores.isEmpty());	
		
	}	
	
	@Test
	void buscaJogador() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("pedra");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador2");
		jogador2.setJogada("tesoura");
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Jogador3");
		jogador3.setJogada("papel");
		Jogador jogador4 = new Jogador();
		jogador4.setNome("Jogador4");
		jogador4.setJogada("spock");
		Jogador jogador5 = new Jogador();
		jogador5.setNome("Jogador5");
		jogador5.setJogada("lagarto");
		
		jokenpo.adicionaJogador(jogador1);
		jokenpo.adicionaJogador(jogador2);
		jokenpo.adicionaJogador(jogador3);
		jokenpo.adicionaJogador(jogador4);
		jokenpo.adicionaJogador(jogador5);
		
		Jogador jogador = jokenpo.buscaJogador("Jogador3");
		assertNotNull(jogador);	
		
	}
	
	@Test
	void adicionaJogadorSemJogada() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");

		assertThrows(JogadorException.class, () -> jokenpo.adicionaJogador(jogador1));
	
	}
	
	@Test
	void adicionaJogadaInvalida() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("corda");

		assertThrows(JogadorException.class, () -> jokenpo.adicionaJogador(jogador1));
	
	}
	
	
	@Test
	void adicionaJogadorMesmoNome() {
		
		Jokenpo jokenpo = new Jokenpo();
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Jogador1");
		jogador1.setJogada("pedra");
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Jogador1");
		jogador2.setJogada("tesoura");

		jokenpo.adicionaJogador(jogador1);
		assertThrows(JogadorException.class, () -> jokenpo.adicionaJogador(jogador2));
	
	}
	
	@Test
	void jogoSemJogadores() {
		
		Jokenpo jokenpo = new Jokenpo();
		List<Jogador> vencedores = jokenpo.executarJogo();
		assert(vencedores.isEmpty());	
	
	}
	

}
