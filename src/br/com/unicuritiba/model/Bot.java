package br.com.unicuritiba.model;

import java.util.Random;

public class Bot extends Jogador{

	Random random = new Random();

	public Bot(String nome) {
		super(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void colocarNavioBot3(Tabuleiro tabuleiroBot) {

		String posicaoNavioBot = String.valueOf(random.nextInt(99));
		if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
			posicaoNavioBot = "0" + posicaoNavioBot;
		}
		boolean encontrouPosicaoBot = false;
		while (!encontrouPosicaoBot) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = tabuleiroBot.getItemTabuleiro(fileira, coluna);
					if (posicaoNavioBot.equals(comparacao)) {
						if (coluna + 1 < 10 && coluna - 1 > -1) {
							tabuleiroBot.setTabuleiro(fileira, coluna, "\u25A0" + "\u25A0");
							tabuleiroBot.setTabuleiro(fileira, coluna-1, "\u25A0" + "\u25A0");
							tabuleiroBot.setTabuleiro(fileira, coluna+1, "\u25A0" + "\u25A0");
							encontrouPosicaoBot = true;
						} else {
							posicaoNavioBot = String.valueOf(random.nextInt(99));
							if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
								posicaoNavioBot = "0" + posicaoNavioBot;
							}
						}
					}
				}
			}
		}
	}
	public void colocarNavioBot5(Tabuleiro tabuleiroBot) {

		String posicaoNavioBot = String.valueOf(random.nextInt(99));
		if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
			posicaoNavioBot = "0" + posicaoNavioBot;
		}
		boolean encontrouPosicaoBot = false;
		while (!encontrouPosicaoBot) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = tabuleiroBot.getItemTabuleiro(fileira, coluna);
					if (posicaoNavioBot.equals(comparacao)) {
						if (coluna + 2 < 10 && coluna - 2 > -1) {
							tabuleiroBot.setTabuleiro(fileira, coluna, "\u25A0" + "\u25A0");
							tabuleiroBot.setTabuleiro(fileira, coluna-1, "\u25A0" + "\u25A0");
							tabuleiroBot.setTabuleiro(fileira, coluna-2, "\u25A0" + "\u25A0");
							tabuleiroBot.setTabuleiro(fileira, coluna+1, "\u25A0" + "\u25A0");
							tabuleiroBot.setTabuleiro(fileira, coluna+2, "\u25A0" + "\u25A0");
							encontrouPosicaoBot = true;
						} else {
							posicaoNavioBot = String.valueOf(random.nextInt(99));
							if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
								posicaoNavioBot = "0" + posicaoNavioBot;
							}
						}
					}
				}
			}
		}
	}
	public void colocarNavioBot1(Tabuleiro tabuleiroBot) {

		String posicaoNavioBot = String.valueOf(random.nextInt(99));
		if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
			posicaoNavioBot = "0" + posicaoNavioBot;
		}
		boolean encontrouPosicaoBot = false;
		while (!encontrouPosicaoBot) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = tabuleiroBot.getItemTabuleiro(fileira, coluna);
					if (posicaoNavioBot.equals(comparacao)) {
						if (coluna < 10 && coluna > -1) {
							tabuleiroBot.setTabuleiro(fileira, coluna, "\u25A0" + "\u25A0");
							encontrouPosicaoBot = true;
						} else {
							posicaoNavioBot = String.valueOf(random.nextInt(99));
							if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
								posicaoNavioBot = "0" + posicaoNavioBot;
							}
						}
					}
				}
			}
		}
	}
	
	public void contarNavioBot(Tabuleiro tabuleiroBot, Bot bot){
		int contadorDeNaviosBot = 0;
		while (contadorDeNaviosBot < 9) {

			bot.colocarNavioBot1(tabuleiroBot);
			bot.colocarNavioBot3(tabuleiroBot);
			bot.colocarNavioBot5(tabuleiroBot);

			for(int fileira = 0; fileira <10; fileira++) {
				for(int coluna =0; coluna <10; coluna++) {
					String validarNVBot = tabuleiroBot.getItemTabuleiro(fileira, coluna);
					if(validarNVBot.equals("\u25A0" + "\u25A0")) {
						contadorDeNaviosBot++;
					}
				}
			}
			if(contadorDeNaviosBot < 9) {
				contadorDeNaviosBot = 0;
				for(int fileira = 0; fileira <10; fileira++) {
					for(int coluna =0; coluna <10; coluna++) {
						String zerarNV = String.valueOf(fileira) + String.valueOf(coluna);
						tabuleiroBot.setTabuleiro(fileira, coluna, zerarNV);
					}
				}
				System.out.println("Contamos seus navios e ta tudo errado, arruma essas posições ae rapá!");
				tabuleiroBot.mostrarTabuleiro();
			}
			else {
				System.out.println("Contamos seus navios e ta tudo certo!");
			}

		}
	}
	
	public void tiroDoBot(Tabuleiro tabuleiroJogador, Bot bot) {

		int tiroBotL = random.nextInt(9);
		int tiroBotC = random.nextInt(9);
		boolean jaAtireiAqui = true;

		while(jaAtireiAqui){
			if (("~~").equals(tabuleiroJogador.getItemTabuleiro(tiroBotL,tiroBotC)) || ("XX").equals(tabuleiroJogador.getItemTabuleiro(tiroBotL,tiroBotC))){
				tiroBotL = random.nextInt(9);
				tiroBotC = random.nextInt(9);
			}else{
				jaAtireiAqui = false;
			}
		}

		if (("\u25A0" + "\u25A0").equals(tabuleiroJogador.getItemTabuleiro(tiroBotL,tiroBotC))) {
			System.out.println("BOT acertou um tiro");
			tabuleiroJogador.setTabuleiro(tiroBotL, tiroBotC, "XX");
			bot.setAcertos();
		}
		else {
			System.out.println("BOT acertou à Água");
			tabuleiroJogador.setTabuleiro(tiroBotL,tiroBotC,"~~");
		}
	}
}
