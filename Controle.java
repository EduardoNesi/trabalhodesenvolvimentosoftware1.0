class Controle {

    // ***************************************************************************************
    // Atributos
    // ***************************************************************************************
    static View tela;
    static Jogador player;
    static GerenciadorMissoes missoes;

    static String mapa[][];

    // ***************************************************************************************
    // Operações/Métodos
    // ***************************************************************************************

    // ============================================================
    // Método que controla o laço principal do jogo
    // ============================================================
    public static void operacao() {

        //// Limpa a tela
        tela.limpar_tela();

        //// Mostra as missões ativas
        /* Obtém a lista de missões */
        String missoes_ativas = missoes.mostrar_missoes();

        /* Apresenta para o usuário */
        tela.mostrar_missoes_ativas(missoes_ativas);

        // Mostra os dados do usuario
        tela.mostrar_infos(player.get_x(), player.get_y());

        // Mostra a pontuação (Obrigatória)
        player.mostrarpontuacao();

        //// Mostra o mapa
        tela.desenhar_mapa(mapa, player.get_x(), player.get_y());

        //// Pede um direção para andar
        String direcao = tela.obter_direcao();

        //// Processa a entrada do usuário
        processar_comando(direcao);

    }

    // ============================================================
    // Método que realiza os procedimentos necessários para cada
    // comando do usuário
    // ============================================================
    public static void processar_comando(String comando) {

        /* Nova posição caso se mova */
        int nova_posicao_x = player.get_x();
        int nova_posicao_y = player.get_y();

        if (comando.equals("a")) {
            nova_posicao_x--;
        } else if (comando.equals("d")) {
            nova_posicao_x++;
        } else if (comando.equals("w")) {
            nova_posicao_y--;
        } else if (comando.equals("s")) {
            nova_posicao_y++;
        }

        /* Se tiver uma parede onde ele quer ir, não faz nada */
        if (mapa[nova_posicao_y][nova_posicao_x].equals("x")) {
            return;
        }

        /* Se não tiver parede, atualiza a posição do jogador */
        player.set_x(nova_posicao_x);
        player.set_y(nova_posicao_y);

        /* Verificar se tem uma missão no local (início ou fim) */
        missoes.verificar_missoes(player.get_x(), player.get_y());

    }

    // ============================================================
    // Verifica no gerenciador de missões se existe uma missão
    // na posição especificada
    // ============================================================
    public static boolean existe_missao(int x, int y) {
        return missoes.existe_missao(x, y);
    }

    // ***************************************************************************************
    // Main
    // ***************************************************************************************

    public static void main(String[] args) throws InterruptedException {
        //// Inicializa os atributos
        /* Interações com o usuário */
        Inicio inicio = new Inicio();
        inicio.exibirTelaInicio();

        mapa = new String[50][50];

        // Declara uma matriz 2D com 50 linhas e 50 colunas
        mapa = new String[50][50];

        // Loop externo para iterar através das linhas do mapa
        for (int y = 0; y < mapa.length; y++) {
            // Loop interno para iterar através das colunas do mapa
            for (int x = 0; x < mapa[0].length; x++) {
                // Verifica se a posição atual está na borda da matriz
                if (y == 0 || y == mapa.length - 1 || x == 0 || x == mapa[0].length - 1) {
                    // Se estiver na borda, define o valor para "x"
                    mapa[y][x] = "x";
                } else {
                    // Caso contrário, define o valor para um espaço em branco
                    mapa[y][x] = " ";
                }
            }
        }

        tela = new View();

        /* Nosso jogador */
        player = new Jogador(3, 3);

        /* Nossas missões */
        missoes = new GerenciadorMissoes();

        int total_missoes = missoes.quantidade_missoes();
        int missoes_completas = missoes.quantidade_missoes_completas();

        //// Inicia o jogo
        while (missoes_completas < total_missoes) {

            operacao();

            int nova_quantidade_de_missoes_completas = missoes.quantidade_missoes_completas();
            if (nova_quantidade_de_missoes_completas > missoes_completas) {
                missoes_completas = nova_quantidade_de_missoes_completas;
                player.aumentarpontuacao(1);
                tela.limpar_tela();
                tela.mostrar_mensagem_missão_completa();
                Thread.sleep(2000);
            }
        }
        tela.limpar_tela();
        System.out.println("Fim de Jogo!! Todas as missões foram concluídas.");

    }
}