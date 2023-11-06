package com.tresEnRaya.tresEnRaya.tablero.domain;

public interface TableroRepository {

    Integer movimiento(Integer columna, Integer fila);
    String limpair();

}
