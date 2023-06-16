package br.com.unicuritiba.model;

public class Tabuleiro {
  
    public void DesenhaTabuleiro(){
    for (int fileira=0; fileira<0.9; fileira += 0.1){
        for (int coluna=0; coluna<0.9; coluna += 0.1){
            System.out.print("|" + fileira + "." + coluna + "|");
        }
        System.out.println("");
    }
    
    }
}
