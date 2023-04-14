class Jogador {

    // ***************************************************************************************
    // Atributos
    // ***************************************************************************************
    private int x;
    private int y;
    private int pontos;

    // ***************************************************************************************
    // Operações/Métodos
    // ***************************************************************************************
    public void mostrarpontuacao() {
        System.out.println("Pontuação: " + pontos);
    }

    public void aumentarpontuacao(int pontos) {
        this.pontos = this.pontos + pontos;
    }

    // ============================================================
    // Getters e setters
    // ============================================================
    public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }

    public void set_x(int x) {
        this.x = x;
    }

    public void set_y(int y) {
        this.y = y;
    }

    // ***************************************************************************************
    // Construtor
    // ***************************************************************************************
    public Jogador(int x, int y) {
        this.x = x;
        this.y = y;
        this.pontos = 0;
    }

}