package br.com.unicuritiba.model;

import java.util.Scanner;

public class Jogador {
	
	Scanner scanner = new Scanner(System.in);
	
	protected String nome;
	protected int acertos;
	protected int pontos;
	
	public Jogador(String nome){
		this.nome = nome;
		this.acertos = 0;
		this.pontos = 100;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAcertos() {
		return acertos;
	}
	public void setAcertos() {
		acertos++;
	}
	public int getPontos() {
		return pontos;
	}
	public void diminuirPontos() {
		pontos--;
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
		
		if (("NV").equals(matrizBot.getItemTabuleiro(tiroL,tiroC))) {
			System.out.println("KABUM! Você acertou um tiro!");
			matrizBotVisivel.setTabuleiro(tiroL, tiroC, "XX");
			jogador.setAcertos();

		} else {
			System.out.println("JOGADOR acertou à água");
			matrizBotVisivel.setTabuleiro(tiroL,tiroC, "~~");
			jogador.diminuirPontos();
		}
	}

}
