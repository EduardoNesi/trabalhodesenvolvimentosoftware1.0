import java.util.Scanner;

public class View {

    // Scanner para ler a entrada
    Scanner sc;

    // ***************************************************************************************
    // Operações/Métodos
    // ***************************************************************************************

    // ============================================================
    // Limpa informações anteriores do terminal para mostrar
    // o jogo novamente
    // ============================================================
    public void limpar_tela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mostrar_mensagem_missão_completa() {
        System.out.println("Missão Completa!");
    }

    // ============================================================
    // Desenha o mapa do jogo, considerando a posição do jogador
    // e quaisquer missões
    // ============================================================
    public void desenhar_mapa(String[][] mapa, int jogador_x, int jogador_y) {
        int largura_visivel = 12; // Definindo a largura visível como 6 colunas
        int altura_visivel = 12; // Definindo a altura visível como 6 linhas

        // Definindo as coordenadas do canto superior esquerdo da janela visível
        int inicio_x = Math.max(0, jogador_x - largura_visivel / 2);
        int inicio_y = Math.max(0, jogador_y - altura_visivel / 2);

        for (int y = inicio_y; y < inicio_y + altura_visivel && y < mapa.length; y++) {
            for (int x = inicio_x; x < inicio_x + largura_visivel && x < mapa[0].length; x++) {

                /* Caso seja a posição do jogador */
                if (jogador_y == y && jogador_x == x) {
                    System.out.print("@");

                }
                /* Caso seja a posição do início de uma missão */
                else if (Controle.existe_missao(x, y)) {
                    System.out.print("M");

                }
                /* Caso não tenha nada no local */
                else {
                    System.out.print(mapa[y][x]);

                }

            }
            System.out.println();
        }
    }

    // ============================================================
    // Apresenta o texto de todas as missões ativas para o usuário
    // ============================================================
    public void mostrar_missoes_ativas(String missoes_ativas) {
        System.out.println(missoes_ativas);

    }

    // ============================================================
    // Obtém o input do usuário
    // ============================================================
    public String obter_direcao() {
        /* Pede um direção para andar ou sair do jogo */
        System.out.println("Digite uma direção: (W, A, S, D) ou Q para sair");

        /* Obtém a resposta */
        String entrada = sc.nextLine();

        /* Converte para minúsculas para aceitar tanto maiúsculas quanto minúsculas */
        entrada = entrada.toLowerCase();

        /* Se a entrada for "q", encerra o programa */
        if (entrada.equals("q")) {
            System.exit(0);
        }

        /* Retorna a entrada */
        return entrada;
    }

    // ============================================================
    // Mostra informações do jogador
    // ============================================================
    public void mostrar_infos(int x, int y) {

        /* Mostra a coordenada atual */
        System.out.println("Coordenada atual: (" + x + ", " + y + ")");
    }

    // ***************************************************************************************
    // Construtor
    // ***************************************************************************************
    public View() {
        /* Inicializa o Scanner */
        sc = new Scanner(System.in);
    }
}
