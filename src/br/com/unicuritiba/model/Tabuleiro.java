package br.com.unicuritiba.model;

import java.util.Scanner;

public class Tabuleiro {
	Scanner scanner = new Scanner(System.in);
	private String[][] Tabuleiro;

	public Tabuleiro(){
		this.Tabuleiro = new String[10][10];
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				this.Tabuleiro[linha][coluna] = Integer.toString(linha) + Integer.toString(coluna);
			}
		}
	}

	public String getItemTabuleiro(int linha, int coluna) {
		return Tabuleiro[linha][coluna];
	}

	public void setTabuleiro(int linha, int coluna, String valorInserido) {
		this.Tabuleiro[linha][coluna] = valorInserido;
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

	public String verificarVH(String orientacao){
		while (!orientacao.equalsIgnoreCase("V") && !orientacao.equalsIgnoreCase("H")) {
			System.out.println("Orientação incorreta!");
			System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
			orientacao = scanner.nextLine();
		}
		return orientacao;
	}

	public String validarDoisDigitos(String navio) {
		while (!navio.matches("\\d{2}")) {
			System.out.println("Valor Inválido");
			System.out.println("Digite a posição inicial do Navio");
			navio = scanner.nextLine();
		}
		return navio;
	}

	public String verificarSeCabeH(String posicao, Navio navio, Tabuleiro tabuleiroJogador) {
		boolean cabeNoTabuleiro = false;
		while(!cabeNoTabuleiro) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = String.valueOf(fileira)+String.valueOf(coluna);
					if (comparacao.equals(posicao)) {
						if (coluna + (navio.getTamanho()/2) < 10 && coluna - (navio.getTamanho()/2) > -1 ) {
							cabeNoTabuleiro = true;
						}
						else {
							System.out.println("Navio não cabe nessa posição");
							System.out.println("Coloque em outro lugar: ");
							posicao = scanner.nextLine();
							posicao = tabuleiroJogador.validarDoisDigitos(posicao);
						}
					}
				}
			}
		}
		return posicao;
	}

	public String verificarSeCabeV(String posicao, Navio navio, Tabuleiro tabuleiroJogador) {
		boolean cabeNoTabuleiro = false;
		while(!cabeNoTabuleiro) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = String.valueOf(fileira)+String.valueOf(coluna);
					if (comparacao.equals(posicao)) {
						if (fileira + (navio.getTamanho()/2) < 10 && fileira - (navio.getTamanho()/2) > -1 ) {
							cabeNoTabuleiro = true;
						}
						else {
							System.out.println("Navio não cabe nessa posição");
							System.out.println("Coloque em outro lugar: ");
							posicao = scanner.nextLine();
							posicao = tabuleiroJogador.validarDoisDigitos(posicao);
						}
					}
				}
			}
		}
		return posicao;
	}

	public void preencherTabuleiro(Tabuleiro tabuleiroJogador, Navio navio) {

		System.out.println("");
		System.out.println("Escolha uma orientação para seu navio");
		System.out.println("(V) para vertical e (H) para horizontal");		
		String orientacao = scanner.nextLine(); 
		orientacao = tabuleiroJogador.verificarVH(orientacao);
		navio.setOrientacao(orientacao);

		if (navio.getOrientacao().equalsIgnoreCase("H")) {
			System.out.println("");
			System.out.println("Escolha uma posição para seu navio de tamanho " +navio.getTamanho());
			String posicao = scanner.nextLine();
			posicao = tabuleiroJogador.validarDoisDigitos(posicao);
			posicao = tabuleiroJogador.verificarSeCabeH(posicao, navio, tabuleiroJogador);
			char posicao1 = posicao.charAt(0);
			char posicao2 = posicao.charAt(1);

			for (int indice = 0; indice < navio.getTamanho(); indice++) {
				tabuleiroJogador.setTabuleiro(Character.getNumericValue(posicao1), (indice+(Character.getNumericValue(posicao2)-(navio.getTamanho()/2))), "\u25A0" + "\u25A0");

			}
			tabuleiroJogador.mostrarTabuleiro();
		}
		else if(navio.getOrientacao().equalsIgnoreCase("V")){
			System.out.println("");
			System.out.println("Escolha uma posição para seu navio de tamanho de tamanho " +navio.getTamanho());
			String posicao = scanner.nextLine();
			posicao = tabuleiroJogador.validarDoisDigitos(posicao);
			posicao = tabuleiroJogador.verificarSeCabeV(posicao, navio, tabuleiroJogador);
			char posicao1 = posicao.charAt(0);
			char posicao2 = posicao.charAt(1);

			for (int indice = 0; indice < navio.getTamanho(); indice++) {
				tabuleiroJogador.setTabuleiro(Character.getNumericValue(posicao1)+indice-(navio.getTamanho()/2), (Character.getNumericValue(posicao2)), "\u25A0" + "\u25A0");

			}
			tabuleiroJogador.mostrarTabuleiro();
		}
	}

	public String verificarDestruido(String tiroCompleto, Tabuleiro matrizBot){
		boolean jaDestruiAqui = true;
		int tiroL = Character.getNumericValue(tiroCompleto.charAt(0));
		int tiroC = Character.getNumericValue(tiroCompleto.charAt(1));

		while(jaDestruiAqui){
			if (("XX").equals(matrizBot.getItemTabuleiro(tiroL, tiroC))){
				System.out.println("Essa parte do navio já foi destruida!");
				System.out.println("Escolha outro alvo: ");
				tiroCompleto = scanner.nextLine();
				tiroL = Character.getNumericValue(tiroCompleto.charAt(0));
				tiroC = Character.getNumericValue(tiroCompleto.charAt(1));

			}else{
				jaDestruiAqui = false;
			}
		}
		return tiroCompleto;
	}

	public void manterJogo(Tabuleiro tabuleiroJogador, Tabuleiro tabuleiroBotVisivel, Tabuleiro tabuleiroBot, Jogador jogador, Bot roboAdversario) {
		boolean mantem = true;
		while(mantem){
			if(jogador.getAcertos() < 17 && roboAdversario.getAcertos() < 17) {
				System.out.println("========Campo do Jogador========");
				System.out.println("");
				tabuleiroJogador.mostrarTabuleiro();
				System.out.println("");
				System.out.println("==========Campo do Bot==========");
				System.out.println("");
				tabuleiroBotVisivel.mostrarTabuleiro();
				System.out.println("");
				System.out.println("Escolha um alvo!");
				System.out.println("Digite o número do alvo");
				String tiroCompleto = scanner.nextLine();
				jogador.atirar(tiroCompleto, tabuleiroBot, tabuleiroBotVisivel, jogador);
				roboAdversario.tiroDoBot(tabuleiroJogador, roboAdversario);
			}
			else {
				mantem = false;
			}
			if(roboAdversario.getAcertos()==8) {
				roboAdversario.intimidar(roboAdversario, jogador);
			}
			if(jogador.getAcertos()==8) {
				roboAdversario.intimidar(jogador, roboAdversario);
			}	
		}
	}
}
