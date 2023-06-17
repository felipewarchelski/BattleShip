package br.com.unicuritiba.model;

public class Jogador {

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

	public void atirar(String tiroCompleto, String[][] matrizComparada, String[][] matrizMarcada) {

		String tiroL = String.valueOf(tiroCompleto.charAt(0));
		String tiroC = String.valueOf(tiroCompleto.charAt(1));
		if (("\u25A0" + "\u25A0").equals(matrizComparada[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)])) {
			System.out.println("KABUM! Você acertou um tiro!");
			matrizMarcada[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "XX";
		} else {
			System.out.println("JOGADOR acertou à água");
			matrizMarcada[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "~~";
		}
	}

	
	
}