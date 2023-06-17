package br.com.unicuritiba.model;
import java.util.Random;

public class Bot{
	private String nomeDoBot;

	//Construtor 
	public Bot(String nome) {
		nomeDoBot = nome;
	}
	
	Random random = new Random();

	public void colocarNavioBot(String [][] matrizBot) {
		String posicaoNavioBot = String.valueOf(random.nextInt(99));
		if (Integer.valueOf(posicaoNavioBot) >= 0 && Integer.valueOf(posicaoNavioBot) < 10) {
			posicaoNavioBot = "0" + posicaoNavioBot;
		}
		
		boolean encontrouPosicaoBot = false;
		while (!encontrouPosicaoBot) {
			for (int fileira = 0; fileira < 10; fileira++) {
				for (int coluna = 0; coluna < 10; coluna++) {
					String comparacao = matrizBot[fileira][coluna];
					if (posicaoNavioBot.equals(comparacao)) {
						if (coluna + 1 < 10 && coluna - 1 > -1) {
							matrizBot[fileira][coluna] = "\u25A0" + "\u25A0";
							matrizBot[fileira][coluna - 1] = "\u25A0" + "\u25A0";
							matrizBot[fileira][coluna + 1] = "\u25A0" + "\u25A0";
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

	public void tiroDoBot(String[][]matriz) {
		String tiroBotL = String.valueOf(random.nextInt(9));
		String tiroBotC = String.valueOf(random.nextInt(9));
		
		if (("\u25A0" + "\u25A0").equals(matriz[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)])) {
			System.out.println("BOT acertou um tiro");
			matriz[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] = "XX";
		}
		else {
			System.out.println("BOT acertou à Água");
			matriz[Integer.valueOf(tiroBotL)][Integer.valueOf(tiroBotC)] = "~~";
		}
	}
	
}