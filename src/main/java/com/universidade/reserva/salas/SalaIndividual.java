package com.unversidade.reserva.salas;

public class SalaIndividual extends Sala {
    public SalaIndividual(String nome) {
        super(nome, 1, "Individual");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Sala Individual: " + getNome() + ", Capacidade: " + getCapacidade());
    }
}