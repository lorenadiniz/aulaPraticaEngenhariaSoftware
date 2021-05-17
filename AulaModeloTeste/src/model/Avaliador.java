package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
	private List<Lance> maiores;

	private void pegaOsMaioresNo(Leilao leilao) {

		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())

					return 1;

				if (o1.getValor() > o2.getValor())

					return -1;

				return 0;

			}

		});
		// if para caso a lista tenha menos que 3 elementos
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());

	}

	public List<Lance> getTresMaiores() {
		return this.maiores;
	}

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;

	public void avalia(Leilao leilao) {
		if (leilao.getLances().size() == 0) {
			maiorDeTodos = 0;
			menorDeTodos = 0;
		}

		for (Lance lance : leilao.getLances()) {

			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();

			}
			if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();

			}

		}
		pegaOsMaioresNo(leilao);

	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}
}
