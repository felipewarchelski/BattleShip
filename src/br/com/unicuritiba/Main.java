package br.com.unicuritiba;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[][] matriz = new String[10][10];
        String[][] matrizBot = new String[10][10];

        // Criação/Preenchimento das matriz
        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                matriz[i][ind] = Integer.toString(i) + Integer.toString(ind);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                System.out.print(" " + matriz[i][ind]);
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                matrizBot[i][ind] = Integer.toString(i) + Integer.toString(ind);
            }
        }

        // Mensagem de inicio
        System.out.println("Bem Vindo ao Extreme BattleShip");
        System.out.println("Vamos iniciar a organização da sua frota");
        System.out.println();

        // Escolha da posição e orientação pro jogador
        System.out.println();
        System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
        String orientacao = scanner.nextLine();
        System.out.println("Digite a posição inicial do Navio de tamanho 3 (horizontal):");
        String n3 = scanner.nextLine();
        while (Integer.parseInt(n3) > 99 || Integer.parseInt(n3) < 0 || n3.length() != 2) {
            System.out.println("Valor Inválido");
            System.out.println("Digite a posição inicial do Navio de tamanho 3:");
            n3 = scanner.nextLine();
        }

        // Escolha da posição pro bot
        String navioBot = String.valueOf(random.nextInt(99));
        if (Integer.valueOf(navioBot) >= 0 && Integer.valueOf(navioBot) < 10) {
            navioBot = "0" + navioBot;
        }
        boolean encontrouPosicaoBot = false;
        while (!encontrouPosicaoBot) {
            for (int fileira = 0; fileira < 10; fileira++) {
                for (int coluna = 0; coluna < 10; coluna++) {
                    String comparacao = matrizBot[fileira][coluna];
                    if (navioBot.equals(comparacao)) {
                        if (coluna + 1 < 10 && coluna - 1 > -1) {
                            matrizBot[fileira][coluna] = "NV";
                            matrizBot[fileira][coluna - 1] = "NV";
                            matrizBot[fileira][coluna + 1] = "NV";
                            encontrouPosicaoBot = true;
                        } else {
                            navioBot = String.valueOf(random.nextInt(99));
                            if (Integer.valueOf(navioBot) >= 0 && Integer.valueOf(navioBot) < 10) {
                                navioBot = "0" + navioBot;
                            }
                        }
                    }
                }
            }
        }

        // POSICIONAR NAVIO HORIZONTAL
        boolean encontrouPosicao = false;
        if (orientacao.equals("H") || orientacao.equals("h")) {
            while (!encontrouPosicao) {
                for (int fileira = 0; fileira < 10; fileira++) {
                    for (int coluna = 0; coluna < 10; coluna++) {
                        String comparacao = matriz[fileira][coluna];
                        if (n3.equals(comparacao)) {
                            if (coluna + 1 < 10 && coluna - 1 > -1) {
                                matriz[fileira][coluna] = "NV";
                                matriz[fileira][coluna - 1] = "NV";
                                matriz[fileira][coluna + 1] = "NV";
                                encontrouPosicao = true;
                            } else {
                                System.out.println("Posição sem espaço para o navio de tamanho 3.");
                                System.out.print("Tente outra posição: ");
                                n3 = scanner.nextLine();
                            }
                        }
                    }
                }
            }
        }
        // POSICIONAR NAVIO VERTICAL
        else {
            while (!encontrouPosicao) {
                for (int fileira = 0; fileira < 10; fileira++) {
                    for (int coluna = 0; coluna < 10; coluna++) {
                        String comparacao = matriz[fileira][coluna];
                        if (n3.equals(comparacao)) {
                            if (coluna + 1 < 10 && coluna - 1 > -1) {
                                matriz[fileira][coluna] = "NV";
                                matriz[fileira - 1][coluna] = "NV";
                                matriz[fileira + 1][coluna] = "NV";
                                encontrouPosicao = true;
                            } else {
                                System.out.println("Posição sem espaço para o navio de tamanho 3.");
                                System.out.print("Tente outra posição: ");
                                n3 = scanner.nextLine();
                            }
                        }
                    }
                }
            }
        }

        // Mostrar Campos
        System.out.println("Campo Jogador");
        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                System.out.print(" " + matriz[i][ind]);
            }
            System.out.println();
            
        }
        System.out.println("");
        System.out.println("Campo do Bot");
        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                System.out.print(" " + matrizBot[i][ind]);
            }
            System.out.println();
        }
        System.out.println("");

        // Tiro Jogador
        System.out.println("Vamos testar sua pontaria");
        System.out.println("Digite a linha do alvo");
        String tiroL = scanner.nextLine();
        System.out.println("Digite a coluna do alvo");
        String tiroC = scanner.nextLine();

        if ("NV".equals(matrizBot[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)])) {
            System.out.println("Kabum! Você acertou um tiro!");
            matrizBot[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "XX";
        } else {
            System.out.println("Jogador acertou à água");
			matrizBot[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "~~";
        }
        //tiro do bot
        String tiroBotL = String.valueOf(random.nextInt(9));
		String tiroBotC = String.valueOf(random.nextInt(9));
		
		if (matriz[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] == "NV") {
			System.out.println("Bot acertou um tiro");
			matriz[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] = "XX";
		}
		else {
			System.out.println("Bot acertou à Água");
			matriz[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] = "~~";
		}
		
		System.out.println("");
		System.out.println("Campo do Jogador");
		System.out.println("");
		for (int i = 0; i < 10; i++) {
			for (int ind = 0; ind < 10; ind++) {
				System.out.print(" " + matriz[i][ind]);
			}
			System.out.println();
		}
		System.out.println("");
		System.out.println("Campo do Bot");
		System.out.println("");
		for (int i = 0; i < 10; i++) {
			for (int ind = 0; ind < 10; ind++) {
				System.out.print(" " + matrizBot[i][ind]);
			}
			System.out.println();
		}


      
        scanner.close();
    }

}