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
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void avaliarLancesOrdenadosDecrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 100.0));

		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saída com o esperado
		double maiorEsperado = 250.0;
		double menorEsperado = 100.0;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void avaliarLancesAleatorios() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 100.0));

		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saída com o esperado
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

		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saída com o esperado
		double maiorEsperado = 250.0;
		double menorEsperado = 250.0;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void avaliarTresMaioresLances() {
		// cenários de entrada
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		// execução
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// avaliação
		List<Lance> maiores = leiloeiro.getTresMaiores();

		// comparação
		assertEquals(3, maiores.size());

	}
}
