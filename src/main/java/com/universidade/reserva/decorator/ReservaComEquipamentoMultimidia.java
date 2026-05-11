package com.universidade.reserva.decorators;

import com.universidade.reserva.IReserva;

public class ReservaComEquipamentoMultimidia extends ReservaDecorator {
    private static final double CUSTO_MULTIMIDIA = 25.0;

    public ReservaComEquipamentoMultimidia(IReserva reservaDecorada) {
        super(reservaDecorada);
    }

    @Override
    public String getDescricao() {
        return reservaDecorada.getDescricao() + ", com equipamento multimídia";
    }

    @Override
    public double getCusto() {
        return reservaDecorada.getCusto() + CUSTO_MULTIMIDIA;
    }
}
