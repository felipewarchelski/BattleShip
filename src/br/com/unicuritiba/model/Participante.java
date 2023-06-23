package br.com.unicuritiba.model;

import java.util.Scanner;

public abstract class Participante {
	
Scanner scanner = new Scanner(System.in);
	
	protected String nome;
	protected int acertos;
	protected int pontos;
	
	public Participante(String nome){
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
	public abstract void intimidar(Participante ameacador, Participante ameacado);
	
}
