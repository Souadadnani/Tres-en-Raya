package com.tresEnRaya.tresEnRaya.tablero.domain;

import java.util.List;

public interface TableroRepository {

    void movimiento(Tablero tablero);

    String [][]  getTablero();

    void limpair();

}
