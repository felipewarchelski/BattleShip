package br.com.unicuritiba;

// import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Random random = new Random();

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
        System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
        String orientacao = scanner.nextLine();
        System.out.println("Digite a posição inicial do Navio de tamanho 3 (horizontal):");
        String n3 = scanner.nextLine();
        while (Integer.parseInt(n3) > 99 || Integer.parseInt(n3) < 0 || n3.length() != 2) {
            System.out.println("Valor Inválido");
            System.out.println("Digite a posição inicial do Navio de tamanho 3:");
            n3 = scanner.nextLine();
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
        //POSICIONAR NAVIO VERTICAL
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
                if (encontrouPosicao) {
                    break;
                }
            }
        }

        // MOSTRAR "NV" NAS FILEIRAS E COLUNAS SELECIONADAS
        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                System.out.print(" " + matriz[i][ind]);
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("Navio posicionado!");

        // ATIRAR
        System.out.println("Vamos testar sua pontaria");
        System.out.println("Digite a linha do alvo");
        String tiroL = scanner.nextLine();
        System.out.println("Digite a coluna do alvo");
        String tiroC = scanner.nextLine();

        if ("NV".equals(matriz[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)])) {
            System.out.println("Você acertou um tiro");
            matriz[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "XX";
        } else {
            System.out.println("Água");
        }

        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                System.out.print(" " + matriz[i][ind]);
            }
            System.out.println();
        }

        scanner.close();
    }

}
