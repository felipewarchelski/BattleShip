package br.com.unicuritiba;

import java.util.Random;
import java.util.Scanner;

import br.com.unicuritiba.model.Bot;
import br.com.unicuritiba.model.Jogador;
import br.com.unicuritiba.model.Tabuleiro;

public class Main {

    public static void main(String[] args) {

    	Scanner scanner = new Scanner(System.in);
        Random random = new Random();
    	Bot matrizBot = new Bot();
    	Tabuleiro matrizBotVisivel = new Tabuleiro();
        
    	System.out.println("Bem Vindo ao Extreme BattleShip");
    	System.out.println("Insira o nome de sua esquadra");
    	String nomeJogador = scanner.nextLine();
    	Jogador matrizJogador = new Jogador(nomeJogador);
       
    	
        //MENSAGEM DE INICIO
        System.out.println("Vamos iniciar a organização da sua frota");
        System.out.println();

        System.out.println("====POSICIONE SEUS NAVIOS!====");
        matrizJogador.mostrarTabuleiro();
        
        //ESCOLHA POSIÇÃO E ORIENTAÇÃO DO NAVIO
        System.out.println();
        System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
        String orientacao = scanner.nextLine();
        while (!orientacao.equalsIgnoreCase("V") && !orientacao.equalsIgnoreCase("H")) {
            System.out.println("Orientação incorreta!");
            System.out.println("Escolha a orientação do navio(Vertical = [V] ou Horizontal = [H]):");
            orientacao = scanner.nextLine();
        }
        
        System.out.println("Digite a posição inicial do Navio de tamanho 3:");
        String navio3 = scanner.nextLine();
        matrizJogador.validarLocal(navio3);

        //ESCOLHA POSIÇÃO BOT
        
        matrizBot.colocarNavioBot();
        
        /*Quando se chama o metodo colocarNavio precisa colocar qual a orientação que o jogador quis,
        e em que local ele será colocado */
        
        matrizJogador.colocarNavio(orientacao, navio3);
        
        //MOSTRAR CAMPOS
        System.out.println("=======CAMPO DO JOGADOR=======");
        matrizJogador.mostrarTabuleiro();
        
        System.out.println("");
        System.out.println("Navios Posicionados!");
        System.out.println("");
        
        /*agora não sabemos mais onde o bot coloca os navios dele, se quiser testar
        da pra chamar o metodo mostrar tabuleiro pra matrizBot sem ser a visivel
        dai vai ver onde ele colocou*/
        
        System.out.println("=========CAMPO DO BOT=========");
        matrizBotVisivel.mostrarTabuleiro();
        
        System.out.println("");

        //TIRO DO JOGADOR
        System.out.println("Vamos testar sua pontaria!");
        System.out.println("Digite o número do alvo! com dois digitos");
        String tiroCompleto = scanner.nextLine();
        
        /* pra chamar o metodo atirar você precisa colocar uma String de dois dígitos a 
         matriz alvo do tiro e a matriz que vai receber a marcação, que é a do botVisivel*/
        
        matrizJogador.atirar(tiroCompleto, matrizBot, matrizBotVisivel);
        
        /* O Tiro do bot tem que ser na matriz do jogador*/
        
        matrizBot.tiroDoBot(matrizJogador);
		
        System.out.println("");
		System.out.println("=======CAMPO DO JOGADOR=======");
		System.out.println("");
		matrizJogador.mostrarTabuleiro();
		System.out.println("");
		System.out.println("=========CAMPO DO BOT=========");
		System.out.println("");
		matrizBotVisivel.mostrarTabuleiro();
      
        scanner.close();
    }

}