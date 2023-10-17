package STP_Milhoes;

import java.util.Scanner;

public class Main {

	// constantes - das opcoes
	private static final String NOVO = "NOVO";
	private static final String SAI = "SAI";
	private static final String AJUDA = "AJUDA";
	private static final String JOGA = "JOGA";
	private static final String FIM = "FIM";
	// indica o estado do jogo - se existe ou n/0
	private static boolean jogoOn = false;
	// mantem o funcionamento do programa
	private static boolean programaOn = true;
	// vector que guarda chave dos numeros escolhidos
	private static int[] chaveNumero = new int[5];
	// vector que guarda chave das estrelas escolhidas
	private static int[] chaveEstrela = new int[2];
	// objecto tipo Jogo
	private static Jogo Game;
	// valor acumulado no jogo
	private static double valorAcumulado = 0;

	/**
	 * METODO MAIN - PROGRAMA PRINCIPAL
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		// Organizacao do jogo
		System.out.print(">");
		while (programaOn) {
			String opcao = lerOpcao(in);
			executaOpcao(in, opcao);
		}
		in.close();
	}

	/*
	 * mostrar interface Menu, quando aciona ajuda
	 */
	private static void Menu() {
		if (jogoOn) {
			System.out.println("joga - Simula uma aposta, dando uma chave");
			System.out.println("fim - Termina o jogo em curso");
			System.out.println("ajuda - Mostra os comandos existentes");
			System.out.print("STPMilhoes>");
		} else {
			System.out.println("novo - Novo jogo dando um valor inicial");
			System.out.println("sai - Termina a execucao do programa");
			System.out.println("ajuda - Mostra os comandos existentes");
			System.out.print(">");
		}
	}

	/*
	 * ler a opcao
	 */
	private static String lerOpcao(Scanner in) {
		String opcao = in.next().toUpperCase();
		return opcao;
	}

	/*
	 * executa opcao de acordo com o estado de jogo, sendo iniciado ou nao
	 */
	private static void executaOpcao(Scanner in, String opcao) {
		if (jogoOn) {
			switch (opcao) {
			case JOGA:
				jogar(in);
				break;
			case FIM:
				terminarJogo();
				break;
			case AJUDA:
				Menu();
				break;
			default:
				System.out.println("Comando inexistente");
				System.out.print("STPMilhoes>");
				break;
			}
		} else {
			switch (opcao) {
			case NOVO:
				novoJogo(in);
				break;
			case SAI:
				fimPrograma();
				break;
			case AJUDA:
				Menu();
				break;
			default:
				System.out.println("Comando inexistente");
				System.out.print(">");
			}
		}
	}

	/*
	 * processa a criacao do jogo STPMilhoes
	 */
	private static void novoJogo(Scanner in) {
		jogoOn = true;
		valorAcumulado += in.nextDouble();
		Game = new Jogo(valorAcumulado);
		System.out.println("Jogo iniciado. Valor do premio: " + valorAcumulado + " Dobras.");
		System.out.print("STPMilhoes>");
	}

	/*
	 * termina a execucao do programa
	 */
	private static void fimPrograma() {
		System.out.println("Valor acumulado: " + valorAcumulado + " Dobras. Até a proxima.");
		programaOn = false;
	}

	/*
	 * simula uma aposta
	 */
	private static void jogar(Scanner in) {
		// prencher ChaveNumero e ChaveEstrela com aposta do jogador
		for (int n = 0; n < chaveNumero.length; n++) {
			chaveNumero[n] = in.nextInt();
		}
		for (int e = 0; e < chaveEstrela.length; e++) {
			chaveEstrela[e] = in.nextInt();
		}
		if (checkNumber() && checkStar() == true) {
			Game.apostar(chaveNumero, chaveEstrela);
			int Level = Game.premioLevel();
			if (Level > 0) {
				System.out.println("Obrigado pela aposta. Premio de nivel: " + Level);
				System.out.print("STPMilhoes>");
			} else {
				System.out.println("Obrigado pela aposta.");
				System.out.print("STPMilhoes>");
			}
		} else {
			System.out.println("Chave incorrecta");
			System.out.print("STPMilhoes>");
		}
	}

	/*
	 * verifica se a chave de numeros e valida
	 */
	private static boolean checkNumber() {
		boolean number = true;
		// verifica se aposta � > 1 e < 50
		for (int all = 0; all < chaveNumero.length; all++) {
			if (chaveNumero[all] > 50 || chaveNumero[all] < 1) {
				number = false;
				break;
			}
		}
		// verifica se o numero esta repetido
		if (number == true) {
			for (int i = 0; i < chaveNumero.length; i++) {
				for (int f = chaveNumero.length - 1; f > i; f--) {
					if (chaveNumero[i] == chaveNumero[f]) {
						number = false;
					}
				}
			}
		}
		return number;
	}

	/*
	 * verifica se a chave de estrelas e valida
	 */
	private static boolean checkStar() {
		boolean star = true;
		// verifica se aposta � > 1 e < 12
		for (int all = 0; all < chaveEstrela.length; all++) {
			if (chaveEstrela[all] > 12 || chaveEstrela[all] < 1) {
				star = false;
				break;
			}
		}
		// verifica se a estrela esta repetida
		if (star == true) {
			for (int i = 0; i < chaveEstrela.length; i++) {
				for (int f = chaveEstrela.length - 1; f > i; f--) {
					if (chaveEstrela[i] == chaveEstrela[f]) {
						star = false;
					}
				}
			}
		}
		return star;
	}

	/*
	 * termina o jogo em curso
	 */
	private static void terminarJogo() {
		jogoOn = false;
		// recebe os premios de cada nivel de acordo com quantidade de jogador
		double[] award = Game.premioDeJogador();
		// recebe a quantidade de jogador em determinado nivel
		int[] player = Game.ReturnPlayer();
		// mostrar a lista de premios
		double valorGanho = 0;
		int j = 1;
		for (int i = 0; i < award.length; i++) {
			if (player[i] > 0) {
				System.out.println(
						"Nivel: " + j++ + " Jogadores: " + player[i] + " valor de premio: " + award[i] + " Dobras");
				// soma a quantidade de premio total a distribuir para todos jogadores
				valorGanho += award[i];
			} else {
				System.out.println("Nivel: " + j++ + " Jogadores: 0");
			}
		}
		valorAcumulado = valorAcumulado - valorGanho;
		System.out.println("Valor acumulado: " + valorAcumulado + " Dobras");
		Game.ReiniciePlayer();
		System.out.print(">");
	}
}
