package  com.universidade.reserva.salas;

public abstract class Sala {
    protected String nome;
    protected int capacidade;
    protected String tipo;

    public Sala(String nome, int capacidade, String tipo) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract void exibirDetalhes();
}