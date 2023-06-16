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
        System.out.println("Digite a posição inicial do Navio de tamanho 3 (horizontal):");
        String n3 = scanner.nextLine();
        while (Integer.parseInt(n3) > 99 || Integer.parseInt(n3) < 0 || n3.length() != 2) {
            System.out.println("Valor Inválido");
            System.out.println("Digite a posição inicial do Navio de tamanho 3 (horizontal):");
            n3 = scanner.nextLine();
        }

        boolean encontrouPosicao = false;
        while (!encontrouPosicao) {
            for (int fileira = 0; fileira < 10; fileira++) {
                for (int coluna = 0; coluna < 10; coluna++) {
                    String comparacao = matriz[fileira][coluna];
                    if (n3.equals(comparacao)) {
                        if (coluna + 1 < 10 && coluna - 1 > -1) {
                            matriz[fileira][coluna] = "NN";
                            matriz[fileira][coluna - 1] = "NN";
                            matriz[fileira][coluna + 1] = "NN";
                            encontrouPosicao = true;
                        } else {
                            System.out.println("Posição sem espaço para o navio de tamanho 3.");
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

        // MOSTRAR "NV" NAS FILEIRAS E COLUNAS SELECIONADAS
        for (int i = 0; i < 10; i++) {
            for (int ind = 0; ind < 10; ind++) {
                System.out.print(" " + matriz[i][ind]);
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println(" Navio posicionado!");

        /*
         * atirar(int linha, int coluna) {
         * if (tabuleiro[linha][coluna] == NAVIO) {
         * System.out.println("Você acertou um navio!");
         * tabuleiro[linha][coluna] = ATINGIDO;
         * } else if (tabuleiro[linha][coluna] == ATINGIDO) {
         * System.out.println("Você já atingiu essa posição antes.");
         * } else {
         * System.out.println("Você errou o tiro.");
         */

        scanner.close();
    }

}
