package com.tresEnRaya.tresEnRaya.tablero.applicacion;

import com.tresEnRaya.tresEnRaya.tablero.domain.TableroRepository;

public class TableroUseCases {

    private TableroRepository tableroRepository;

    public TableroUseCases(TableroRepository tableroRepository) {
        this.tableroRepository = tableroRepository;
    }

    Integer movimiento(Integer fila, Integer columna){
        Integer [][] tablero = new Integer[fila][columna];

        return fila;
    }

}
