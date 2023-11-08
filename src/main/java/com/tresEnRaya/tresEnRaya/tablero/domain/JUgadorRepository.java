package com.tresEnRaya.tresEnRaya.tablero.domain;

public interface JUgadorRepository {

    void saveJugador(Jugador jugador);
    Jugador getJugador(Integer id);
}
