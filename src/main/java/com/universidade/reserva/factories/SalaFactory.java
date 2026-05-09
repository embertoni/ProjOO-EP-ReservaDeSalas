package com.universidade.reserva.factories;

import com.universidade.reserva.salas.Sala;
import com.universidade.reserva.salas.SalaIndividual;
import com.universidade.reserva.salas.SalaDeGrupo;
import com.universidade.reserva.salas.Laboratorio;

public class SalaFactory {
    public static Sala criarSala(String tipo, String nome, int capacidade) {
        switch (tipo.toLowerCase()) {
            case "individual":
                return new SalaIndividual(nome);
            case "grupo":
                return new SalaDeGrupo(nome, capacidade);
            case "laboratorio":
                return new Laboratorio(nome, capacidade);
            default:
                throw new IllegalArgumentException("Tipo de sala desconhecido: " + tipo);
        }
    }
}
