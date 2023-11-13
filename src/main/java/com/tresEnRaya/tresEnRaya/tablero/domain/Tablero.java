package com.tresEnRaya.tresEnRaya.tablero.domain;

public class Tablero {

    private Integer fila;
    private Integer columna;
    private Integer idJugador;

    public Tablero(Integer idJugador, Integer fila, Integer columna) {
        this.idJugador = idJugador;
        this.columna = columna;
        this.fila = fila;

    }

    public Integer getIdJugador() {
        return idJugador;
    }
    public Integer getFila() {
        return fila;
    }

    public Integer getColumna() {
        return columna;
    }

}
