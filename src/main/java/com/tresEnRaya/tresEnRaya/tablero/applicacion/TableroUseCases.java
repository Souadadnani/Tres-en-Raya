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

    public Character [][] getTablero(){

        Character [][] tabla = new Character[3][3];
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla.length; j++) {
                tabla[i][j] = ' ';
            }
        }

        for(Tablero t: this.tableroRepository.getTablero()){
            if (t.getIdJugador() == 1){
                tabla[t.getFila()-1][t.getColumna()-1] = 'X';
            }else{
                tabla[t.getFila()-1][t.getColumna()-1] = 'O';
            }
        }
        return tabla;
    }

    public void limpiar(){
        this.tableroRepository.limpair();
    }

}
