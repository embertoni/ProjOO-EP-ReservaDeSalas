package com.universidade.reserva;

import com.universidade.reserva.salas.Sala;
import java.time.LocalDateTime;

public class Reserva {
    private String id;
    private Sala sala;
    private String usuario;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Reserva(String id, Sala sala, String usuario, LocalDateTime inicio, LocalDateTime fim) {
        this.id = id;
        this.sala = sala;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fim = fim;
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

    public String toString() {
        return "Reserva [ID=" + id + ", Sala=" + sala.getNome() + ", Usuário=" + usuario +
                ", Início=" + inicio + ", Fim=" + fim + "]";
    }
}