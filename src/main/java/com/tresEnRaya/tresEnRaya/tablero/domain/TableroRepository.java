package com.tresEnRaya.tresEnRaya.tablero.domain;

import java.util.List;

public interface TableroRepository {

    List<Tablero> movimiento(Tablero tablero);

    List<Tablero> getTablero();

    void limpair();

}
