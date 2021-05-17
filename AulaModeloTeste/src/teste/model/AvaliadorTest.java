package teste.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class AvaliadorTest {
	@Test
	public void avaliarLancesOrdenadosCrescente() {
		// cen�rio: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// executando a a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a sa�da com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void avaliarLancesOrdenadosDecrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 100.0));

		// executando a a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a sa�da com o esperado
		double maiorEsperado = 250.0;
		double menorEsperado = 100.0;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void avaliarLancesAleatorios() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 100.0));

		// executando a a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a sa�da com o esperado
		double maiorEsperado = 300.0;
		double menorEsperado = 100.0;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void avaliarApenasUmLance() {
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));

		// executando a a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a sa�da com o esperado
		double maiorEsperado = 250.0;
		double menorEsperado = 250.0;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void avaliarTresMaioresLances() {
		// cen�rios de entrada
		Usuario joao = new Usuario("Jo�o");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		// execu��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// avalia��o
		List<Lance> maiores = leiloeiro.getTresMaiores();

		// compara��o
		assertEquals(3, maiores.size());

	}
}
