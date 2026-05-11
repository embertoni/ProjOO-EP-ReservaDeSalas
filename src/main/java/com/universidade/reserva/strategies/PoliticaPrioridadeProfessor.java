package com.universidade.reserva.strategies;

import com.universidade.reserva.Reserva;
import java.util.List;

public class PoliticaPrioridadeProfessor implements PoliticaDeReserva {

    @Override
    public boolean podeReservar(List<Reserva> reservasExistentes, Reserva novaReserva) {
        boolean novaReservaEhProfessor = novaReserva.getUsuario().toLowerCase().contains("professor");

        for (Reserva existente : reservasExistentes) {
            if (existente.getSala().getNome().equals(novaReserva.getSala().getNome()) &&
                novaReserva.getInicio().isBefore(existente.getFim()) &&
                novaReserva.getFim().isAfter(existente.getInicio())) {

                boolean existenteEhProfessor = existente.getUsuario().toLowerCase().contains("professor");
                if (novaReservaEhProfessor && !existenteEhProfessor) {
                    System.out.println("Conflito: Reserva de professor tem prioridade sobre reserva de aluno. A reserva existente será substituída.");
                    return true;
                } else if (!novaReservaEhProfessor && existenteEhProfessor) {
                    System.out.println("Conflito: Reserva de aluno não pode substituir reserva de professor.");
                    return false;
                } else {
                    System.out.println("Conflito de horário para a mesma sala.");
                    return false;
                }
            }
        }
        return true;
    }
}
