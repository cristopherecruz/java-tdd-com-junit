package br.com.caelum.leilao.servico;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	@Test
	public void validarLanceMaiorMenorEsperado() {

		// Parte 1: Monta Cenário
		Usuario user1 = new Usuario("user1");
		Usuario user2 = new Usuario("user2");
		Usuario user3 = new Usuario("user3");

		Leilao leilao = new Leilao("Playstation 5 Novo");
		leilao.propoe(new Lance(user1, 250.00));
		leilao.propoe(new Lance(user2, 300.00));
		leilao.propoe(new Lance(user3, 400.00));

		// Parte 2: Comportamento do método (Ação)
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// Parte 3: Validação
		double maiorEsperado = 400.00;
		double menorEsperado = 250.00;
		double mediaEsperada = 316.6666666666667;

		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		Assert.assertEquals(mediaEsperada, leiloeiro.getMediaLance(), 0.00001);

	}

}
