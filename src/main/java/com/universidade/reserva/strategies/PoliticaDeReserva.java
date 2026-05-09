package com.universidade.reserva.strategies;

import com.universidade.reserva.Reserva;
import java.time.LocalDateTime;
import java.util.List;

public interface PoliticaDeReserva {
    boolean podeReservar(List<Reserva> reservasExistentes, Reserva novaReserva);
}
