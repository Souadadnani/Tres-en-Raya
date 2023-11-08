package com.tresEnRaya.tresEnRaya.tablero.infrastructure.Controller;

import com.tresEnRaya.tresEnRaya.tablero.domain.Tablero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TableroController {

    @GetMapping("/tablero")
    String tablero(Model model, @RequestParam(name = "idJugador") Integer idJugador,
                   @RequestParam(name = "fila") Integer fila, @RequestParam(name = "columna") Integer columna){

        model.addAttribute(fila);
        model.addAttribute(columna);
        model.addAttribute(idJugador);

        return "tablero";
    }
}
