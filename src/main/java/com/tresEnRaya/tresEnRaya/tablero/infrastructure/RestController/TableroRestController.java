package com.tresEnRaya.tresEnRaya.tablero.infrastructure.RestController;

import com.tresEnRaya.tresEnRaya.tablero.applicacion.TableroUseCases;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.infrastructure.TableroRepositoryMySQL;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TableroRestController {

    private TableroUseCases tableroUseCasess;

    public TableroRestController() {
        this.tableroUseCasess = new TableroUseCases(
                new TableroRepositoryMySQL()
        );

    }

    @PostMapping(path = "/movimiento", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Tablero> movimiento(@RequestBody Tablero tablero){
         return this.tableroUseCasess.movimiento(tablero);
    }

    @PostMapping("/limpiar")
    Character[][] limpiar(){
        return this.tableroUseCasess.limpiar();
    }


}
