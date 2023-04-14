import java.util.Scanner;

public class Inicio {

    // Scanner para ler a entrada do usuário
    Scanner sc;

    // Método para exibir a tela de início e aguardar a entrada do usuário
    public void exibirTelaInicio() {
        // Exibir a imagem de início
        System.out.println("******************************");
        System.out.println("*                            *");
        System.out.println("*     Bem-vindo ao jogo!     *");
        System.out.println("*                            *");
        System.out.println("******************************");
        System.out.println();
        System.out.println("Aperte enter para começar o jogo...");

        // Aguardar a entrada do usuário
        sc.nextLine();
    }

    // Construtor da classe
    public Inicio() {
        sc = new Scanner(System.in);
    }
}
