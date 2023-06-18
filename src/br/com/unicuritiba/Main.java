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
        String[][] matrizJogador = new String[10][10];
    	String[][] matrizBot = new String [10][10];
    	String[][] matrizBotVisivel = new String [10][10];
    	Tabuleiro tabuleiro = new Tabuleiro();
        Bot bot = new Bot(null);
        
    	System.out.println("Bem Vindo ao Extreme BattleShip");
    	System.out.println("Insira o nome de sua esquadra");
    	String nomeJogador = scanner.nextLine();
    	
    	Jogador jogador = new Jogador(nomeJogador);
        
        tabuleiro.construirTabuleiro(matrizJogador);
        tabuleiro.construirTabuleiro(matrizBot);
        tabuleiro.construirTabuleiro(matrizBotVisivel);
        
        //MENSAGEM DE INICIO
        System.out.println("Bem Vindo ao Extreme BattleShip");
        System.out.println("Vamos iniciar a organização da sua frota");
        System.out.println();

        System.out.println("====POSICIONE SEUS NAVIOS!====");
        tabuleiro.mostrarTabuleiro(matrizJogador);
        
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
        tabuleiro.validarLocal(navio3);

        //ESCOLHA POSIÇÃO BOT
        
        bot.colocarNavioBot(matrizBot);
        
        /*Quando se chama o metodo colocarNavio precisa colocar qual a orientação que o jogador quis,
        qual a matriz onde será colocado o navio e em qual local ele será colocado */
        
        tabuleiro.colocarNavio(orientacao, matrizJogador, navio3);
        
        //MOSTRAR CAMPOS
        System.out.println("=======CAMPO DO JOGADOR=======");
        tabuleiro.mostrarTabuleiro(matrizJogador);
        
        System.out.println("");
        System.out.println("Navios Posicionados!");
        System.out.println("");
        
        /*agora não sabemos mais onde o bot coloca os navios dele, se quiser testar
        da pra chamar o metodo mostrar tabuleiro pra matrizBot sem ser a visivel
        dai vai ver onde ele colocou*/
        
        System.out.println("=========CAMPO DO BOT=========");
        tabuleiro.mostrarTabuleiro(matrizBotVisivel);
        
        System.out.println("");

        //TIRO DO JOGADOR
        System.out.println("Vamos testar sua pontaria!");
        System.out.println("Digite o número do alvo! com dois digitos");
        String tiroCompleto = scanner.nextLine();
        
        /* pra chamar o metodo atirar você precisa colocar uma String de dois dígitos a 
         matriz alvo do tiro e a matriz que vai receber a marcação, que é a do botVisivel*/
        
        jogador.atirar(tiroCompleto, matrizBot, matrizBotVisivel);
        
        /* O Tiro do bot tem que ser na matriz do jogador*/
        
        bot.tiroDoBot(matrizJogador);
		
		System.out.println("");
		System.out.println("=======CAMPO DO JOGADOR=======");
		System.out.println("");
		tabuleiro.mostrarTabuleiro(matrizJogador);
		System.out.println("");
		System.out.println("=========CAMPO DO BOT=========");
		System.out.println("");
		tabuleiro.mostrarTabuleiro(matrizBotVisivel);


      
        scanner.close();
    }

}