import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem vindo ao Batalha Naval");
        System.out.println("O jogo consiste em uma batalha, onde você alocará navios em seu mapa e seu oponente fará o mesmo.");
        System.out.println("vence aquele que destruir a frota inimiga primeiro, mas claro nenhum dos dois sabe onde estão os navios do oponente");



        System.out.println("Digite a coluna que deseja atacar: (1-10)");
        int coluna = scanner.nextInt();
        System.out.println("Digite a fileira que deseja atacar: (1-10)");
        int fileira = scanner.nextInt();

        String x = "1";
        x.desenhaTabuleiro();

        scanner.close();

    }

    
}
