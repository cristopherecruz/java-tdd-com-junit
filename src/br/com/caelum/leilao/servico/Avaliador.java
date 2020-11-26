package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double mediaDeTodos = 0.00;

	public void avalia(Leilao leilao) {

		double totalLances = 0.00;
		
		for (Lance lance : leilao.getLances()) {

			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}

			if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}

			totalLances+=lance.getValor();
			
		}

		mediaDeTodos = totalLances / leilao.getLances().stream().count();
		
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}
	
	public double getMediaLance() {
		return mediaDeTodos;
	}

}
