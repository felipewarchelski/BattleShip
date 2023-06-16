package br.com.unicuritiba;

import java.util.Random;
import java.util.Scanner;
import br.com.unicuritiba.model.Tabuleiro;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		String[][] matriz = new String[10][10];

		for (int i = 0; i < 10; i++) {
			for (int ind = 0; ind < 10; ind++) {
				matriz[i][ind] = Integer.toString(i) + Integer.toString(ind);
			}
		}

		System.out.println("Bem Vindo ao Extreme BattleShip");
		System.out.println("Vamos iniciar a organização da sua frota");
		System.out.println();

		for (int i = 0; i < 10; i++) {
			for (int ind = 0; ind < 10; ind++) {
				System.out.print(" " + matriz[i][ind]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Digite a posição inicial do Navio de tamanho 3 (horizontal):");
		String n3 = scanner.nextLine();

		boolean encontrouPosicao = false;
		boolean colocouCerto = false;
		while (!colocouCerto) {
			for (int i = 0; i < 10; i++) {
				for (int ind = 0; ind < 10; ind++) {
					String comparacao = matriz[i][ind];
					if (n3.equals(comparacao)) {
						if (ind + 2 < 10) {
							matriz[i][ind] = "NV";
							matriz[i][ind + 1] = "NV";
							matriz[i][ind + 2] = "NV";
							encontrouPosicao = true;
							colocouCerto = true;
							break;
						} else {
							System.out.println("Posição inválida para o navio de tamanho 3.");
							System.out.print("Tente outra posição: ");
							n3 = scanner.nextLine();
						}
					}
				}
				if (encontrouPosicao) {
					break;
				}
			}
		}

		if (!encontrouPosicao) {
			System.out.println("Posição não encontrada no tabuleiro.");
		}

		for (int i = 0; i < 10; i++) {
			for (int ind = 0; ind < 10; ind++) {
				System.out.print(" " + matriz[i][ind]);
			}
			System.out.println();
		}
		
		

		/*atirar(int linha, int coluna) {
	        if (tabuleiro[linha][coluna] == NAVIO) {
	            System.out.println("Você acertou um navio!");
	            tabuleiro[linha][coluna] = ATINGIDO;
	        } else if (tabuleiro[linha][coluna] == ATINGIDO) {
	            System.out.println("Você já atingiu essa posição antes.");
	        } else {
	            System.out.println("Você errou o tiro.");*/
		
		
		
		scanner.close();
	}

}
