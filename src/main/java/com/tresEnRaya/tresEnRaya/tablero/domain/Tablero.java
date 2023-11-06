package com.tresEnRaya.tresEnRaya.tablero.domain;

public class Tablero {

    private char [][] tablero;
    private Integer posicionFila;
    private Integer posicionColumna;
    private Integer jugador;

    public Tablero(char[][] tablero, Integer posicionColumna, Integer posicionFila) {
        this.tablero = tablero;
        this.posicionColumna = posicionColumna;
        this.posicionFila = posicionFila;
        this.jugador = 1;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Integer getPosicionFila() {
        return posicionFila;
    }

    public Integer getPosicionColumna() {
        return posicionColumna;
    }

    public Integer getJugador() {
        return jugador;
    }

    public void setJugador(Integer jugador) {
        this.jugador = jugador;
    }
}
