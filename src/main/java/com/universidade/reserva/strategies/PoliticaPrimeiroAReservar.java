package com.universidade.reserva.strategies;

import com.universidade.reserva.Reserva;
import java.util.List;

public class PoliticaPrimeiroAReservar implements PoliticaDeReserva {

    @Override
    public boolean podeReservar(List<Reserva> reservasExistentes, Reserva novaReserva) {
        for (Reserva existente : reservasExistentes) {
            // Verifica se há sobreposição de horários para a mesma sala
            if (existente.getSala().getNome().equals(novaReserva.getSala().getNome()) &&
                novaReserva.getInicio().isBefore(existente.getFim()) &&
                novaReserva.getFim().isAfter(existente.getInicio())) {
                return false; // Conflito encontrado
            }
        }
        return true; // Nenhum conflito, pode reservar
    }
}
