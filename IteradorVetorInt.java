package STP_Milhoes;

public class IteradorVetorInt {

	private int contarNumeros, posicaoAtual;
	private int[] numeros;

	/*
	 * Cria um iterador para o vetor de inteiros dados
	 * 
	 * @param: numeros - vetor de inteiros a iterar
	 * 
	 * @pre: numeros todo preenchido
	 */
	public IteradorVetorInt(int[] numeros) {
		contarNumeros = numeros.length;
		posicaoAtual = 0;
		this.numeros = numeros;
	}

	/*
	 * Cria um iterador para o vetor de inteiros dados
	 * 
	 * @param: numeros - vetor de inteiros a iterar
	 * 
	 * @param: nElems - numero de elementos no vetor
	 * 
	 * @pre: nElems >0 && nElems <= numeros.length
	 */
	public IteradorVetorInt(int[] numeros, int nElems) {
		contarNumeros = nElems;
		posicaoAtual = 0;
		this.numeros = numeros;
	}

	/*
	 * Indica se ha mais inteiros para iterar
	 */
	public boolean hasNextInt() {
		return posicaoAtual < contarNumeros;
	}

	/*
	 * Retorna o proximo inteiro
	 * 
	 * @pre: hasNextInt()
	 */
	public int nextInt() {
		return numeros[posicaoAtual++];
	}

	/*
	 * Reinicia a iteracao
	 */
	public void reinitialize() {
		posicaoAtual = 0;
	}
}
