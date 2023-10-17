package STP_Milhoes;

public class Chave {

	// Numero de jogos/sorteios criados
	private static final int NUMEROJOGO = 10;

	// Numeros das chaves
	private static final int[][] NUMEROS = { { 4, 5, 28, 50, 11 }, { 4, 8, 18, 44, 13 }, { 1, 2, 28, 48, 49 },
			{ 2, 15, 22, 33, 11 }, { 10, 20, 30, 50, 40 }, { 4, 15, 21, 32, 11 }, { 2, 5, 18, 20, 11 },
			{ 6, 7, 28, 50, 14 }, { 1, 5, 33, 50, 11 }, { 4, 6, 28, 45, 10 } };

	// Estrelas das chaves
	private static final int[][] ESTRELAS = { { 4, 5 }, { 4, 6 }, { 4, 10 }, { 9, 10 }, { 1, 5 }, { 6, 7 }, { 1, 11 },
			{ 5, 8 }, { 9, 10 }, { 1, 12 } };

	// Jogo corrente incrementa em 1 cada vez que e criado um jogo
	private static int JOGOATUAL = 0;

	// Identificador de jogo
	private int idJogo;

	/*
	 * Cria uma nova chave
	 */
	public Chave() {
		idJogo = JOGOATUAL;
		JOGOATUAL = ++JOGOATUAL % NUMEROJOGO;
	}

	/*
	 * Cria um iterador para os numeros da chave
	 */
	public IteradorVetorInt criaIteradorNumeros() {
		return new IteradorVetorInt(NUMEROS[idJogo]);
	}

	/*
	 * Cria um iterador para as estrelas da chave
	 */
	public IteradorVetorInt criaIteradorEstrelas() {
		return new IteradorVetorInt(ESTRELAS[idJogo]);
	}
}
