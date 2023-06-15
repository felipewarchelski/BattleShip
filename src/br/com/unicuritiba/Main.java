package br.com.unicuritiba;

import java.util.Random;
import java.util.Scanner;
import br.com.unicuritiba.model.Tabuleiro;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem vindo ao Batalha Naval");
        System.out.println("O jogo consiste em uma batalha, onde você alocará navios em seu mapa e seu oponente fará o mesmo.");
        System.out.println("vence aquele que destruir a frota inimiga primeiro, mas claro nenhum dos dois sabe onde estão os navios do oponente");



        System.out.println("Digite a coluna que deseja atacar: (1-10)");
        int coluna = scanner.nextInt();
        System.out.println("Digite a fileira que deseja atacar: (1-10)");
        int fileira = scanner.nextInt();
        
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.DesenhaTabuleiro();
        scanner.close();

	}

}
