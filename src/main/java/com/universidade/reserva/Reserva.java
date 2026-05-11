package com.universidade.reserva;

import com.universidade.reserva.salas.Sala;
import java.time.LocalDateTime;

public class Reserva implements IReserva {
    private String id;
    private Sala sala;
    private String usuario;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private double custoBase;

    public Reserva(String id, Sala sala, String usuario, LocalDateTime inicio, LocalDateTime fim) {
        this.id = id;
        this.sala = sala;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fim = fim;
        this.custoBase = 50.0;
    }

    public String getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    @Override
    public String getDescricao() {
        return "Reserva da " + sala.getNome() + " por " + usuario + " de " + inicio.toLocalTime() + " a " + fim.toLocalTime();
    }

    @Override
    public double getCusto() {
        return custoBase;
    }

    @Override
    public String toString() {
        return "Reserva [ID=" + id + ", Sala=" + sala.getNome() + ", Usuário=" + usuario +
               ", Início=" + inicio + ", Fim=" + fim + ", Custo Total=" + String.format("%.2f", getCusto()) + "]";
    }
}
