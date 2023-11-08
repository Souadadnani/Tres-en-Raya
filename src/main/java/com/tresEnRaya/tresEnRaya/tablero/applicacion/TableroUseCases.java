package com.tresEnRaya.tresEnRaya.tablero.applicacion;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.domain.TableroRepository;

import java.util.List;

public class TableroUseCases {

    private TableroRepository tableroRepository;

    public TableroUseCases(TableroRepository tableroRepository) {

        this.tableroRepository = tableroRepository;
    }

    public List<Tablero> movimiento(Tablero tablero){
        return this.tableroRepository.movimiento(tablero);
    }

    public List<Tablero> getTablero(){
        return  this.tableroRepository.getTablero();
    }

    public void limpiar(){
        this.tableroRepository.limpair();
    }

}
