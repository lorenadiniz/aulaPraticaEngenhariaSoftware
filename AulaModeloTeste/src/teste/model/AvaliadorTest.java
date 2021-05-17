package teste.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class AvaliadorTest {
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenário: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		// comparando a saída com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;
		Assertions.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		Assertions.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}
}
