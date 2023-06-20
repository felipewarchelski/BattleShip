package br.com.unicuritiba.model;

import java.util.Scanner;


public class Tabuleiro {
	Scanner scanTabuleiro = new Scanner(System.in);

	protected String[][] Tabuleiro;
	protected int acertos;

	public Tabuleiro() {
		this.Tabuleiro = new String[10][10];
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				this.Tabuleiro[linha][coluna] = Integer.toString(linha) + Integer.toString(coluna);
			}
		}
		this.acertos = 0;
	}

	public void setAcertos() {
		this.acertos = acertos + 1;
	}

	public int getAcertos() {
		return this.acertos;
	}

	public void mostrarTabuleiro() {
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				System.out.print(" " + this.Tabuleiro[linha][coluna]);
			}
			System.out.println();
		}
		System.out.println("");
	}

	public void colocarNavio(String orientacao, String n3) {
		boolean encontrouPosicao = false;
		if (orientacao.equalsIgnoreCase("H")) {
			while (!encontrouPosicao) {
				for (int fileira = 0; fileira < 10; fileira++) {
					for (int coluna = 0; coluna < 10; coluna++) {
						String comparacao = this.Tabuleiro[fileira][coluna];
						if (n3.equals(comparacao)) {
							if (coluna + 1 < 10 && coluna - 1 > -1) {
								this.Tabuleiro[fileira][coluna] = "\u25A0" + "\u25A0";
								this.Tabuleiro[fileira][coluna - 1] = "\u25A0" + "\u25A0";
								this.Tabuleiro[fileira][coluna + 1] = "\u25A0" + "\u25A0";
								encontrouPosicao = true;
							} else {
								System.out.println("Posição sem espaço para o navio de tamanho 3.");
								System.out.print("Tente outra posição: ");
								n3 = scanTabuleiro.nextLine();
								n3 = validarLocal(n3);
							}
						}
					}
				}
			}
		}

		// POSICIONAR NAVIO VERTICAL
		else if (orientacao.equalsIgnoreCase("V")) {
			while (!encontrouPosicao) {
				for (int fileira = 0; fileira < 10; fileira++) {
					for (int coluna = 0; coluna < 10; coluna++) {
						String comparacao = this.Tabuleiro[fileira][coluna];
						if (n3.equals(comparacao)) {
							if (fileira + 1 < 10 && fileira - 1 > -1) {
								this.Tabuleiro[fileira][coluna] = "\u25A0" + "\u25A0";
								this.Tabuleiro[fileira - 1][coluna] = "\u25A0" + "\u25A0";
								this.Tabuleiro[fileira + 1][coluna] = "\u25A0" + "\u25A0";
								encontrouPosicao = true;
							} else {
								System.out.println("Posição sem espaço para o navio de tamanho 3.");
								System.out.print("Tente outra posição: ");
								n3 = scanTabuleiro.nextLine();
								n3 = validarLocal(n3);
							}
						}
					}
				}
			}
		}
	}

	public String validarLocal(String navio) {
		while (!navio.matches("\\d{2}")) {
			System.out.println("Valor Inválido");
			System.out.println("Digite a posição inicial do Navio de tamanho 3:");
			navio = scanTabuleiro.nextLine();
		}
		return navio;
	}

	public String[][] getTabuleiro() {
		return this.Tabuleiro;
	}

	public boolean manterJogo(Jogador matrizJogador, Bot matrizBot, Tabuleiro matrizBotVisivel, boolean mantem) {
		while (!mantem) {
			if (matrizJogador.getAcertos() < 3 && matrizBot.getAcertos() < 3) {
				System.out.println("Vamos testar sua pontaria!");
				System.out.println("Digite o número do alvo! com dois digitos");
				String tiroCompleto = scanTabuleiro.nextLine();

				matrizJogador.atirar(tiroCompleto, matrizBot, matrizBotVisivel, matrizJogador);

				matrizBot.tiroDoBot(matrizJogador);

				System.out.println("");
				System.out.println("=======CAMPO DO JOGADOR=======");
				System.out.println("");
				matrizJogador.mostrarTabuleiro();
				System.out.println("");
				System.out.println("=========CAMPO DO BOT=========");
				System.out.println("");
				matrizBotVisivel.mostrarTabuleiro();
			}
			else {
				mantem = true;
			}
		}
		return mantem;
	}
}