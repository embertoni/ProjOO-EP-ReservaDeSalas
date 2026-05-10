package com.universidade.reserva.observers;

import com.universidade.reserva.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioDiarioObserver implements ObservadorReserva {
    private Map<LocalDate, List<Reserva>> reservasPorDia;

    public RelatorioDiarioObserver() {
        this.reservasPorDia = new HashMap<>();
    }

    @Override
    public void atualizar(Reserva reserva, String acao) {
        LocalDate dataReserva = reserva.getInicio().toLocalDate();
        if (!acao.equals("cancelada")) {
            reservasPorDia.computeIfAbsent(dataReserva, k -> new ArrayList<>()).add(reserva);
        }
        System.out.println("[Relatório Diário] Atualizado para a data: " + dataReserva.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    public void gerarRelatorioDiario(LocalDate data) {
        System.out.println("\n--- Relatório de Reservas para " + data.format(DateTimeFormatter.ISO_LOCAL_DATE) + " ---");
        List<Reserva> reservasDoDia = reservasPorDia.getOrDefault(data, new ArrayList<>());
        if (reservasDoDia.isEmpty()) {
            System.out.println("Nenhuma reserva para esta data.");
        } else {
            for (Reserva r : reservasDoDia) {
                System.out.println("- " + r);
            }
        }
        System.out.println("---------------------------------------");
    }
}
