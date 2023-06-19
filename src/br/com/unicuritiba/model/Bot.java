package br.com.unicuritiba.model;
import java.util.Random;

public class Bot extends Tabuleiro{
	
	private String nomeDoBot;
	Random random = new Random();
		
		
	public void colocarNavioBot() {
		String posicaoNavioBot = String.valueOf(random.nextInt(99));
		if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
			posicaoNavioBot = "0" + posicaoNavioBot;
		}
		
		boolean encontrouPosicaoBot = false;
		while (!encontrouPosicaoBot) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = this.Tabuleiro[fileira][coluna];
					if (posicaoNavioBot.equals(comparacao)) {
						if (coluna + 1 < 10 && coluna - 1 > -1) {
							this.Tabuleiro[fileira][coluna] = "\u25A0" + "\u25A0";
							this.Tabuleiro[fileira][coluna - 1] = "\u25A0" + "\u25A0";
							this.Tabuleiro[fileira][coluna + 1] = "\u25A0" + "\u25A0";
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

	public void tiroDoBot(Jogador matrizJogador) {
		String tiroBotL = String.valueOf(random.nextInt(9));
		String tiroBotC = String.valueOf(random.nextInt(9));
		
		if (("\u25A0" + "\u25A0").equals(matrizJogador.getTabuleiro()[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)])) {
			System.out.println("BOT acertou um tiro");
			matrizJogador.getTabuleiro()[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] = "XX";
		}
		else {
			System.out.println("BOT acertou à Água");
			matrizJogador.getTabuleiro()[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] = "~~";
		}
	}
	
	
}