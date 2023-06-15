package br.com.unicuritiba.model;

public class Navio {

    private int tamanho[];
    private boolean estado;
    private String posicao;
    
	public Navio(int[] tamanho, boolean estado, String posicao) {
		super();
		this.tamanho = tamanho;
		this.estado = estado;
		this.posicao = posicao;
	}

	public int[] getTamanho() {
		return tamanho;
	}

	public void setTamanho(int[] tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
    
    

}
