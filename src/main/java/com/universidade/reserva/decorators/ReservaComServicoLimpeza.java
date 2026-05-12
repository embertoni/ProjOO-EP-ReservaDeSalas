package com.universidade.reserva.decorators;

import com.universidade.reserva.IReserva;

public class ReservaComServicoLimpeza extends ReservaDecorator {
    private static final double CUSTO_LIMPEZA = 30.0;

    public ReservaComServicoLimpeza(IReserva reservaDecorada) {
        super(reservaDecorada);
    }

    @Override
    public String getDescricao() {
        return reservaDecorada.getDescricao() + ", com serviço de limpeza";
    }

    @Override
    public double getCusto() {
        return reservaDecorada.getCusto() + CUSTO_LIMPEZA;
    }
}
