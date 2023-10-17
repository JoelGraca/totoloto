package STP_Milhoes;

//Class Jogo interage com as classes chave e iterador
public class Jogo {
	// recebe o valor calculado acumulado

	private double montante;
	// vector que conta quantidade de jogador num determinado nivel de 1-13
	private static int[] playerLevel = new int[13];
	// guarda a quantidade de numeros e estrelas acertadas
	private int numberAcertados;
	private int starAcertadas;
	// objetos de outras classes
	Premios Premio;
	IteradorVetorInt Numeros;
	IteradorVetorInt Estrelas;

	// Construtor
	public Jogo(double capital) {
		// TODO Auto-generated constructor stub
		Chave Key = new Chave();

		Numeros = Key.criaIteradorNumeros();
		Estrelas = Key.criaIteradorEstrelas();
		Premio = new Premios();
		montante = capital;

	}
	// retorna o nivel de premio ganho

	public int premioLevel() {
		return Premio.nivelPremio(numberAcertados, starAcertadas);
	}
	// Fazer uma aposta

	public void apostar(int[] apostaNumeros, int[] apostaEstrelas) {
		// reinicializacao dos number e star
		numberAcertados = 0;
		starAcertadas = 0;
		// verificar a quantidade de numeros acertados
		for (int cn = 0; cn < apostaNumeros.length; cn++) {
			if (Numeros.hasNextInt()) {
				int rigthNumber = Numeros.nextInt();
				for (int n = 0; n < apostaNumeros.length; n++) {
					if (rigthNumber == apostaNumeros[n]) {
						numberAcertados++;
					}
				}
			}
		}
		Numeros.reinitialize();
		// verifica a quantidade de estrelas acertadas
		for (int ce = 0; ce < apostaEstrelas.length; ce++) {
			if (Estrelas.hasNextInt()) {
				int rightStar = Estrelas.nextInt();
				for (int e = 0; e < apostaEstrelas.length; e++) {
					if (rightStar == apostaEstrelas[e]) {
						starAcertadas++;

					}
				}
			}
		}
		Estrelas.reinitialize();
		// registra jogador
		jogadorEmNivel();
	}
	// chama objecto chave

	public Chave novaChave() {
		return new Chave();
	}
	// devolve vector contendo a valor de premio por jogador para cada nivel

	public double[] premioDeJogador() {
		return Premio.valorPremio(montante, playerLevel);
	}
	// contabiliza quantidade de jogadores em cada nivel. organizado de 1-13

	public void jogadorEmNivel() {
		int level = premioLevel();
		if (premioLevel() > 0) {
			playerLevel[level - 1]++;
		}
	}

	/*
	 * metodo que devolve a quantidade de jogadores em cada nivel
	 */
	public int[] ReturnPlayer() {
		return playerLevel;
	}

	/*
	 * reinicializate player number
	 */
	public void ReiniciePlayer() {
		for (int a = 0; a < playerLevel.length; a++) {
			playerLevel[a] = 0;
		}
	}
}
