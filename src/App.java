import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int fileiraRandom = random.nextInt();

        System.out.println("Digite a coluna que deseja atacar: (A-Z)");
        String coluna = scanner.nextLine().toUpperCase();
        System.out.println("Digite a fileira que deseja atacar: (1-26)");
        String fileira = scanner.nextLine();

        String jogada = coluna + fileira;

        scanner.close();

    }
}
