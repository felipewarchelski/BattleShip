package br.com.unicuritiba.model;

public class Jogador extends Tabuleiro{

	private String nome;
	private int pontos;

	public void Pontuar() {
		this.pontos ++;
	}

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

	public boolean verificarDestruido(String tiroCompleto, Bot matrizBot){
		boolean jaDestruiAqui = true;
		String tiroL = String.valueOf(tiroCompleto.charAt(0));
		String tiroC = String.valueOf(tiroCompleto.charAt(1));

		while(jaDestruiAqui){
			if (("XX").equals(matrizBot.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)])){
				System.out.println("Essa parte do navio já foi destruida!");
				System.out.println("Escolha outro alvo: ");
				tiroCompleto = scanTabuleiro.nextLine();
				tiroL = String.valueOf(tiroCompleto.charAt(0));
				tiroC = String.valueOf(tiroCompleto.charAt(1));

			}else{
				jaDestruiAqui = false;
			}
		}
		return false;
	}

	public void atirar(String tiroCompleto, Bot matrizBot, Tabuleiro matrizBotVisivel, Jogador acertos) {
		boolean foraDaTabela = true;
		while (foraDaTabela){
			if (!tiroCompleto.matches("\\d{2}")){
				System.out.println("Você precisa digitar um número de dois digitos!");
				System.out.println("Tente novamente: ");
				tiroCompleto = scanTabuleiro.nextLine();
			}
			else {
				foraDaTabela = false;
			}
		}
		if (Integer.valueOf(tiroCompleto) >= 0 && Integer.valueOf(tiroCompleto) < 10) {
			tiroCompleto = "0" + tiroCompleto;
		}
		String tiroL = String.valueOf(tiroCompleto.charAt(0));
		String tiroC = String.valueOf(tiroCompleto.charAt(1));
		acertos.verificarDestruido(tiroCompleto, matrizBot);

		if (Integer.valueOf(tiroCompleto) >= 0 && Integer.valueOf(tiroCompleto) < 10) {
			tiroCompleto = "0" + tiroCompleto;
		}
		if (("\u25A0" + "\u25A0").equals(matrizBot.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)])) {
			System.out.println("KABUM! Você acertou um tiro!");
			matrizBotVisivel.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "XX";
			acertos.setAcertos();
		} else {
			System.out.println("JOGADOR acertou à água");
			matrizBotVisivel.getTabuleiro()[Integer.valueOf(tiroL)][Integer.valueOf(tiroC)] = "~~";
		}
	}
}