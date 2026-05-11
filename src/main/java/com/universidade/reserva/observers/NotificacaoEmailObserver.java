package com.universidade.reserva.observers;

import com.universidade.reserva.Reserva;

public class NotificacaoEmailObserver implements ObservadorReserva {

    @Override
    public void atualizar(Reserva reserva, String acao) {
        System.out.println("[Notificação por Email] Enviando email para " + reserva.getUsuario() +
                           " sobre a ação \'" + acao + "\' na reserva: " + reserva.getId());
        // Lógica real de envio de email seria implementada aqui
    }
}
