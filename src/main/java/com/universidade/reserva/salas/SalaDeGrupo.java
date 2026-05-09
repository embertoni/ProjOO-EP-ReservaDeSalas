package com.universidade.reserva.salas;

public class SalaDeGrupo extends Sala {
    public SalaDeGrupo(String nome, int capacidade) {
        super(nome, capacidade, "Grupo");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Sala de Grupo: ", getNome() + ", Capacidade: " + getCapacidade());
    }
}