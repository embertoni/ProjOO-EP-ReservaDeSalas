package com.universidade.reserva.decorators;

import com.universidade.reserva.IReserva;

public abstract class ReservaDecorator implements IReserva {
    protected IReserva reservaDecorada;

    public ReservaDecorator(IReserva reservaDecorada) {
        this.reservaDecorada = reservaDecorada;
    }

    @Override
    public String getDescricao() {
        return reservaDecorada.getDescricao();
    }

    @Override
    public double getCusto() {
        return reservaDecorada.getCusto();
    }
}
