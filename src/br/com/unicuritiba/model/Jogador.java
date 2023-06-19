package br.com.unicuritiba.model;

public class Jogador extends Tabuleiro{

	private String nome;
	private int pontos;

	public void Pontuar() {
		this.pontos ++;
	}

	// \/ Esse é o construtor \/
	public Jogador(String nome) {
		this.nome = nome;
		this.pontos = 100;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void diminuirPontos() {
		pontos -= pontos;
	}

	public void atirar(String tiroCompleto,Bot matrizBot, Tabuleiro matrizBotVisivel) {

		String tiroL = String.valueOf(tiroCompleto.charAt(0));
		String tiroC = String.valueOf(tiroCompleto.charAt(1));
		// necessária uma maneira de verificar dentro da instancia matrizBot se os números batem e gravar
		// dentro da instancia matrizBotVisivel
		if (("\u25A0" + "\u25A0").equals(matrizBot.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)])) {
			System.out.println("KABUM! Você acertou um tiro!");
			matrizBotVisivel.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "XX";
		} else {
			System.out.println("JOGADOR acertou à água");
			matrizBotVisivel.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "~~";
		}
	}



}