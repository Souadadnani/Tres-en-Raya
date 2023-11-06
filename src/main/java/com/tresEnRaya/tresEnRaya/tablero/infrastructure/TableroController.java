package com.tresEnRaya.tresEnRaya.tablero.infrastructure;

import com.tresEnRaya.tresEnRaya.tablero.applicacion.TableroUseCases;
import org.springframework.stereotype.Controller;

@Controller
public class TableroController {

    private TableroUseCases tableroUseCases;

    public TableroController(){
        this.tableroUseCases = new TableroUseCases(new TableroRepositoryMySQL());
    }
}
