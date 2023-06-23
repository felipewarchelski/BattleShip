package br.com.unicuritiba;

import java.util.Scanner;

import br.com.unicuritiba.model.Bot;
import br.com.unicuritiba.model.Jogador;
import br.com.unicuritiba.model.Navio;
import br.com.unicuritiba.model.Tabuleiro;

public class Main {

	public static void main(String[] args) {

		Tabuleiro tabuleiroJogador = new Tabuleiro();
		Tabuleiro tabuleiroBot = new Tabuleiro();
		Tabuleiro tabuleiroBotVisivel = new Tabuleiro();
		Scanner scanner = new Scanner(System.in);
		Navio navio1 = new Navio(1);
		Navio navio3 = new Navio(3);
		Navio navio5 = new Navio(5);

		System.out.println("Bem Vindo ao Battle Extreme");
		System.out.println("Digite o nome do Jogador: ");
		String apelido = scanner.nextLine();
		Jogador jogador = new Jogador(apelido);
		System.out.println("Digite o nome do Robo Adversário: ");
		String apelidoDoRobo = scanner.nextLine();
		Bot roboAdversario = new Bot(apelidoDoRobo);
		System.out.println("Batalha declarada "+jogador.getNome()+" vs "+roboAdversario.getNome());

		//imprimir o tabuleiro na tela
		System.out.println("");
		System.out.println("=========Campo Jogador=========");
		tabuleiroJogador.mostrarTabuleiro();

		int contadorDeNavios = 0;
		while (contadorDeNavios < 9) {

			tabuleiroJogador.preencherTabuleiro(tabuleiroJogador, navio1);
			tabuleiroJogador.preencherTabuleiro(tabuleiroJogador, navio3);
			tabuleiroJogador.preencherTabuleiro(tabuleiroJogador, navio5);

			for(int fileira = 0; fileira <10; fileira++) {
				for(int coluna =0; coluna <10; coluna++) {
					String validarNV = tabuleiroJogador.getItemTabuleiro(fileira, coluna);
					if(validarNV.equals("\u25A0" + "\u25A0")) {
						contadorDeNavios++;
					}
				}
			}
			if(contadorDeNavios < 9) {
				contadorDeNavios = 0;
				for(int fileira = 0; fileira <10; fileira++) {
					for(int coluna =0; coluna <10; coluna++) {
						String zerarNV = String.valueOf(fileira) + String.valueOf(coluna);
						tabuleiroJogador.setTabuleiro(fileira, coluna, zerarNV);
					}
				}
				System.out.println("Contamos seus navios e ta tudo errado, arruma essas posições ae rapá!");
				tabuleiroJogador.mostrarTabuleiro();
			}
			else {
				System.out.println("Verificamos sua frota e está tudo certo com as posições!");
			}
		}
		
		roboAdversario.contarNavioBot(tabuleiroBot, roboAdversario);

		//RESULTADO
		tabuleiroBot.mostrarTabuleiro();
		tabuleiroJogador.manterJogo(tabuleiroJogador, tabuleiroBotVisivel, tabuleiroBot, jogador, roboAdversario);
		tabuleiroBotVisivel.mostrarTabuleiro();
		
		if(jogador.getAcertos()>=9) {
			System.out.println(jogador.getNome()+ " ganhou com "+ jogador.getPontos()+ " pontos!");
		}
		else if(roboAdversario.getAcertos()>=9) {
			System.out.println(roboAdversario.getNome() +" humilhou " + jogador.getNome() + "!" + "\n" + "Você perdeu!");
		}
		else {
			System.out.println("Se esse erro foi encontrado infelizmente há falhas no código");
		}
		
		scanner.close();
	}
}
