package com.tresEnRaya.tresEnRaya.tablero.domain;

public class Tablero {

    private Integer posicionFila;
    private Integer posicionColumna;
    private Integer idJugador;

    public Tablero(Integer posicionColumna, Integer posicionFila, Integer idJugador) {

        this.posicionColumna = posicionColumna;
        this.posicionFila = posicionFila;
        this.idJugador = idJugador;
    }


    public Integer getPosicionFila() {
        return posicionFila;
    }

    public Integer getPosicionColumna() {
        return posicionColumna;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

}
