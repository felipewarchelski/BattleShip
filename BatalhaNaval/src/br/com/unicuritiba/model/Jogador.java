package br.com.unicuritiba.model;

import java.util.Scanner;

public class Jogador extends Participante{

	public Jogador(String nome) {
		super(nome);
		
	}
	
	public void atirar(String tiroCompleto, Tabuleiro matrizBot, Tabuleiro matrizBotVisivel, Jogador jogador) {
		boolean foraDaTabela = true;
		while (foraDaTabela){
			if (!tiroCompleto.matches("\\d{2}")){
				System.out.println("Você precisa digitar um número de dois digitos!");
				System.out.println("Tente novamente: ");
				tiroCompleto = scanner.nextLine();
			}
			else {
				foraDaTabela = false;
			}
		}
		int tiroL = Character.getNumericValue(tiroCompleto.charAt(0));
		int tiroC = Character.getNumericValue(tiroCompleto.charAt(1));
		tiroCompleto = matrizBot.verificarDestruido(tiroCompleto, matrizBot);
		tiroL = Character.getNumericValue(tiroCompleto.charAt(0));
		tiroC = Character.getNumericValue(tiroCompleto.charAt(1));
		
		if (("\u25A0" + "\u25A0").equals(matrizBot.getItemTabuleiro(tiroL,tiroC))) {
			System.out.println("KABUM! Você acertou um tiro!");
			matrizBotVisivel.setTabuleiro(tiroL, tiroC, "XX");
			matrizBot.setTabuleiro(tiroL, tiroC, "XX");
			jogador.setAcertos();

		} else {
			System.out.println("JOGADOR acertou à água");
			matrizBotVisivel.setTabuleiro(tiroL,tiroC, "~~");
			jogador.diminuirPontos();
		}
	}

	
	@Override
	public void intimidar(Participante ameacador, Participante ameacado) {
		System.out.println("");
		System.out.println(ameacador.getNome() + " grita: ");
		System.out.println(ameacado.getNome() + "vai dormir com os camarões hoje!");
		System.out.println("");
	}
	
	

}
