package br.com.unicuritiba;

// import java.util.Random;
import java.util.Scanner;

import br.com.unicuritiba.model.Bot;
import br.com.unicuritiba.model.Jogador;
import br.com.unicuritiba.model.Tabuleiro;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// Random random = new Random();
		Bot matrizBot = new Bot();
		Tabuleiro matrizBotVisivel = new Tabuleiro();

		System.out.println("Bem Vindo ao Extreme BattleShip");
		System.out.println("Insira o nome de sua esquadra");
		String nomeJogador = scanner.nextLine();
		Jogador matrizJogador = new Jogador(nomeJogador);


		//MENSAGEM DE INICIO
		System.out.println("Vamos iniciar a organização da sua frota");
		System.out.println();
		System.out.println("====POSICIONE SEUS NAVIOS!====");
		matrizJogador.mostrarTabuleiro();

		//ESCOLHA POSIÇÃO E ORIENTAÇÃO DO NAVIO
		System.out.println();
		System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
		String orientacao = scanner.nextLine();
		while (!orientacao.equalsIgnoreCase("V") && !orientacao.equalsIgnoreCase("H")) {
			System.out.println("Orientação incorreta!");
			System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
			orientacao = scanner.nextLine();
		}
		System.out.println("Digite a posição inicial do Navio de tamanho 3:");
		String navio3 = scanner.nextLine();
		navio3 = matrizJogador.validarLocal(navio3);

		//ESCOLHA POSIÇÃO BOT
		matrizBot.colocarNavioBot();
		matrizJogador.colocarNavio(orientacao, navio3);

		//MOSTRAR CAMPOS
		System.out.println("=======CAMPO DO JOGADOR=======");
		matrizJogador.mostrarTabuleiro();

		System.out.println("");
		System.out.println("Navios Posicionados!");
		System.out.println("");

		System.out.println("=========CAMPO DO BOT=========");
		matrizBotVisivel.mostrarTabuleiro();

		System.out.println("");

		//TIRO DO JOGADOR
		matrizJogador.manterJogo(matrizJogador, matrizBot, matrizBotVisivel, false);
        if (matrizJogador.getAcertos() ==3){
            System.out.println("Parabéns, você venceu!");
        }

		scanner.close();
	}
}