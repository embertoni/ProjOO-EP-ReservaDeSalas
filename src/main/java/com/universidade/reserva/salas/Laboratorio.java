package com.universidade.reserva.salas;

public class Laboratorio extends Sala {
    public Laboratorio(String nome, int capacidade) {
        super(nome, capacidade, "Laboratório");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Laboratório: " + getNome() + ", Capacidade: " + getCapacidade());
    }
}