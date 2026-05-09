package com.universidade.reserva;

import com.universidade.reserva.strategies.PoliticaPrimeiroAReservar;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Iniciado.\n");

        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("Salas disponíveis configuradas: " + config.getAvailableRooms() + "\n");

        ReservaService reservaService = new ReservaService();
        reservaService.setPoliticaDeReserva(new PoliticaPrimeiroAReservar());

        System.out.println("Tentando criar Reserva 1...");
        Reserva reserva1 = reservaService.criarReserva("individual", "Sala Individual 1", 1, "aluno1", LocalDateTime.of(2026, 5, 11, 9, 0), LocalDateTime.of(2026, 5, 11, 10, 0));
        if (reserva1 != null) {
            System.out.println("Reserva 1 criada: " + reserva1 + "\n");
        }

        System.out.println("Tentando criar Reserva 2...");
        Reserva reserva2 = reservaService.criarReserva("grupo", "Sala de Grupo 2", 5, "professor1", LocalDateTime.of(2026, 5, 11, 10, 0), LocalDateTime(2026, 5, 11, 12, 0));
        if (reserva2 != null) {
            System.out.println("Reserva 2 criada: " + reserva2 + "\n");
        }

        System.out.println("Tentando criar Reserva 3...");
        Reserva reserva3 = reservaService.criarReserva("individual", "Sala Individual 1", 1, "aluno2", LocalDateTime.of(2026, 5, 11, 9, 30), LocalDateTime.of(2026, 5, 11, 10, 30));
        if (reserva3 != null) {
            System.out.println("Reserva 3 não criada devido a conflito\n");
        }

        System.out.println("Listando todas as reservas existentes (RF-01):\n");
        List<Reserva> todasReservas = reservaService.getAllReservas();
        if (todasReservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva r : todasReservas) {
                System.out.println(r);
            }
        }
        System.out.println("\n");

        if (reserva1 != null) {
            System.out.println("Tentando cancelar Reserva 1...");
            boolean cancelado = reservaService.cancelarReserva(reserva1.getId());
            if (cancelado) {
                System.out.println("Reserva 1 cancelada com sucesso.\n");
            }
        }

        System.out.println("Listando reservas após cancelamento:\n");
        todasReservas = reservaService.getAllReservas();
        if (todasReservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva r : todasReservas) {
                System.out.println(r);
            }
        }
        System.out.println("\nSistema finalizado.");
    }
}