package com.tresEnRaya.tresEnRaya.tablero.domain;

public interface TableroRepository {

    Tablero movimiento(Integer columna, Integer fila);
    void limpair();

}
