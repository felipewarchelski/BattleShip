package br.com.unicuritiba.model;

import java.util.Scanner;

import javafx.scene.control.Tab;

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

    public void colocarNavio(String orientacao, String[][] matriz, String n3) {
        boolean encontrouPosicao = false;
        if (orientacao.equalsIgnoreCase("H")) {
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
        else if (orientacao.equalsIgnoreCase("V")) {
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
                                //FALTA VALIDAR A POSIÇÃO DIGITADA A CIMA
                            }
                        }
                    }
                }
            }
        }
    }

    public void validarLocal(String navio3) {
        while (!navio3.matches("\\d{2}")) {
            System.out.println("Valor Inválido");
            System.out.println("Digite a posição inicial do Navio de tamanho 3:");
            navio3 = scanTabuleiro.nextLine();
            
        }
    }

}