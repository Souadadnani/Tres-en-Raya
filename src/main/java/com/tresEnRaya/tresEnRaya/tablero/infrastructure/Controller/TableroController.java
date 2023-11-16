package com.tresEnRaya.tresEnRaya.tablero.infrastructure.Controller;

import com.tresEnRaya.tresEnRaya.tablero.applicacion.TableroUseCases;
import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import com.tresEnRaya.tresEnRaya.tablero.infrastructure.TableroRepositoryMySQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class TableroController {

    private TableroUseCases tableroUseCases;
    public TableroController(){
        this.tableroUseCases = new TableroUseCases(new TableroRepositoryMySQL());
    }

    @GetMapping("/tablero")
    public String tablero(Model model){

        Character [][]  tabla = this.tableroUseCases.getTablero();
        model.addAttribute("tabla", tabla);

        return "tablero";
    }

    @PostMapping("/limpiar")
    String limpiar(){
        this.tableroUseCases.limpiar();
        return "redirect:/tablero";
    }


}
