package com.universidade.reserva.observers;

import com.universidade.reserva.Reserva;

public interface ObservadorReserva {
    void atualizar(Reserva reserva, String acao);
}
