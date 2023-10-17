package STP_Milhoes;

public class Premios {

	// vector percentagem do valor
	private static final double[] PERCENTAGEM_VALOR = { 0.432, 0.0415, 0.0192, 0.0145, 0.0148, 0.0167, 0.0138, 0.0175,
			0.0285, 0.041, 0.0495, 0.1385, 0.1725 };
	// vector que carrega premio final dos jogadores ordenadamente por nivel
	private double[] premios;
	// devolve o nivel ganho
	private int premioNivel;

	// Construtor
	public Premios() {
		premioNivel = 0;
		premios = new double[13];
	}

	// calcula o nivel de premio ganho pelo jogador
	public int nivelPremio(int number, int star) {
		if (number == 5 && star == 2) {
			premioNivel = 1;
		} else if (number == 5 && star == 1) {
			premioNivel = 2;
		} else if (number == 5 && star == 0) {
			premioNivel = 3;
		} else if (number == 4 && star == 2) {
			premioNivel = 4;
		} else if (number == 4 && star == 1) {
			premioNivel = 5;
		} else if (number == 3 && star == 2) {
			premioNivel = 6;
		} else if (number == 4 && star == 0) {
			premioNivel = 7;
		} else if (number == 2 && star == 2) {
			premioNivel = 8;
		} else if (number == 3 && star == 1) {
			premioNivel = 9;
		} else if (number == 3 && star == 0) {
			premioNivel = 10;
		} else if (number == 1 && star == 2) {
			premioNivel = 11;
		} else if (number == 2 && star == 1) {
			premioNivel = 12;
		} else if (number == 2 && star == 0) {
			premioNivel = 13;
		}
		return premioNivel;
	}
	// calcula o valor de premio de cada nivel consoante o numero de ganhador

	public double[] valorPremio(double montante, int[] playerQuanty) {
		// i = nivel respectivo de cada premio
		for (int i = 0; i < premios.length; i++) {
			premios[i] = (PERCENTAGEM_VALOR[i] * montante) / playerQuanty[i];
		}
		return premios;
	}

}
