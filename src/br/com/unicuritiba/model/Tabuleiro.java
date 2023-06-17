package br.com.unicuritiba.model;

import java.util.Scanner;

public class Tabuleiro {
	Scanner scanTabuleiro = new Scanner(System.in);

	public void construirTabuleiro(String[][] matriz) {
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				matriz[linha][coluna] = Integer.toString(linha) + Integer.toString(coluna);
			}
		}
	}

	public void mostrarTabuleiro(String[][] matriz) {
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				System.out.print(" " + matriz[linha][coluna]);
			}
			System.out.println();
		}
		System.out.println("");
	}

	public void colocarNavio(String orientacao ,String[][]matriz, String n3) {
		boolean encontrouPosicao = false;
        if (orientacao.equals("H") || orientacao.equals("h")) {
            while (!encontrouPosicao) {
                for (int fileira = 0; fileira < 10; fileira++) {
                    for (int coluna = 0; coluna < 10; coluna++) {
                        String comparacao = matriz[fileira][coluna];
                        if (n3.equals(comparacao)) {
                            if (coluna + 1 < 10 && coluna - 1 > -1) {
                                matriz[fileira][coluna] = "\u25A0" + "\u25A0";
                                matriz[fileira][coluna - 1] = "\u25A0" + "\u25A0";
                                matriz[fileira][coluna + 1] = "\u25A0" + "\u25A0";
                                encontrouPosicao = true;
                            } else {
                                System.out.println("Posição sem espaço para o navio de tamanho 3.");
                                System.out.print("Tente outra posição: ");
                                n3 = scanTabuleiro.nextLine();
                            }
                        }
                    }
                }
            }
        }
        
        // POSICIONAR NAVIO VERTICAL
        else if (orientacao.equals("V") || orientacao.equals("v")) {
            while (!encontrouPosicao) {
                for (int fileira = 0; fileira < 10; fileira++) {
                    for (int coluna = 0; coluna < 10; coluna++) {
                        String comparacao = matriz[fileira][coluna];
                        if (n3.equals(comparacao)) {
                            if (coluna + 1 < 10 && coluna - 1 > -1) {
                                matriz[fileira][coluna] = "\u25A0" + "\u25A0";
                                matriz[fileira - 1][coluna] = "\u25A0" + "\u25A0";
                                matriz[fileira + 1][coluna] = "\u25A0" + "\u25A0";
                                encontrouPosicao = true;
                            } else {
                                System.out.println("Posição sem espaço para o navio de tamanho 3.");
                                System.out.print("Tente outra posição: ");
                                n3 = scanTabuleiro.nextLine();
                            }
                        }
                    }
                }
            }
        }

	}
	
	public void validarLocal(String navio3) {
		while (Integer.parseInt(navio3) > 99 || Integer.parseInt(navio3) < 0 || navio3.length() != 2) {
			System.out.println("Valor Inválido");
			System.out.println("Digite a posição inicial do Navio de tamanho 3:");
			navio3 = scanTabuleiro.nextLine();
		}
	}

	
}