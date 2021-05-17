package teste.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class AvaliadorTest {
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Leilao leilao;

	@BeforeEach
	// Construindo cen�rios de testes comuns
	// @BeforeEach for�a a execu��o do m�todo antes da execu��o de cada um dos
	// testes.
	private void instaciarObjetos() {
		joao = new Usuario("Joao");
		jose = new Usuario("Jos�");
		maria = new Usuario("Maria");
		leilao = new Leilao("Playstation 3 Novo");
	}

	/*
	 * M�todos anotados com @AfterEach s�o executados ap�s a execu��o do m�todo de
	 * teste. Usamos m�todos @AfterEach quando nossos testes consomem recursos que
	 * precisam ser finalizados. Exemplos podem ser testes que acessam banco de
	 * dados, abrem arquivos, abrem sockets etc. M�todos anotados com @BeforeAll
	 * e @AfterAll s�o executados apenas uma vez, antes e depois de todos os m�todos
	 * de teste, respectivamente.
	 */
	@Test
	public void avaliarLancesOrdenadosCrescente() {
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
	public void avaliarSemLance() {

		// executando a a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a sa�da com o esperado
		double maiorEsperado = 0;
		double menorEsperado = 0;
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void avaliarTresMaioresLances() {
		// cen�rios de entrada
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
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);
	}

	@Test
	public void avaliarTresMaioresComUmLance() {
		// cen�rios de entrada
		leilao.propoe(new Lance(joao, 100.0));

		// execu��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// avalia��o
		List<Lance> maiores = leiloeiro.getTresMaiores();

		// compara��o
		assertEquals(1, maiores.size());
		assertEquals(100, maiores.get(0).getValor(), 0.00001);

	}

	@Test
	public void avaliarTresMaioresSemLances() {
		// cen�rios de entrada j� executado no instaciarObjetos() com o @BeforeEach

		// execu��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// avalia��o
		List<Lance> maiores = leiloeiro.getTresMaiores();

		// compara��o
		assertEquals(1, maiores.size());
	}
}
