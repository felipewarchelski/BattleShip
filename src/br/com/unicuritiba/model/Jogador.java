package br.com.unicuritiba.model;

public class Jogador {

    private String nome;
    private int pontos;

    public void Pontuar() {
            this.pontos ++;
        
    }

    Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
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

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

}
