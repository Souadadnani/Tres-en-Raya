package com.tresEnRaya.tresEnRaya.tablero.infrastructure;

import com.tresEnRaya.tresEnRaya.tablero.applicacion.TableroUseCases;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.infrastructure.TableroRepositoryMySQL;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableroRestController {

    private TableroUseCases tableroUseCasess;

    public TableroRestController() {

    }

    @PostMapping(path = "/movimiento", consumes = MediaType.APPLICATION_JSON_VALUE)
    Tablero movimiento(@PathVariable Integer fila, @PathVariable Integer columna){


        return null;

    }


}
