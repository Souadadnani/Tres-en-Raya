package com.tresEnRaya.tresEnRaya.tablero.infrastructure.Controller;

import com.tresEnRaya.tresEnRaya.tablero.applicacion.TableroUseCases;
import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.infrastructure.TableroRepositoryMySQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TableroController {

    private TableroUseCases tableroUseCases;
    public TableroController(){
        this.tableroUseCases = new TableroUseCases(new TableroRepositoryMySQL());
    }

    @GetMapping("/tablero")
    String tablero(Model model){

        List<Tablero> tablero = this.tableroUseCases.getTablero();
        model.addAttribute("tablero", tablero);

        return "tablero";
    }
}
