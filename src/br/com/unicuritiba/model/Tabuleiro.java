package br.com.unicuritiba.model;

public class Tabuleiro {

    private int tamanho[][];
    private String simbolo;
  
    public void DesenhaTabuleiro(){
    for (int fileira=0; fileira<10; fileira++){
        for (int coluna=0; coluna<10; coluna++){
            System.out.print("|" + fileira + "." + coluna + "|");
        }
        System.out.println("");
    }
    
    }
}
