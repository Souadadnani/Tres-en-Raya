package com.tresEnRaya.tresEnRaya.productos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductosController {

    private ProductosUseCases productosUseCases;

    public ProductosController(){
        this.productosUseCases = new ProductosUseCases(new ProductosRepositoryRAM());
    }

    @GetMapping("/productos")
    String getAll(Model model){

        List<Producto> productos = this.productosUseCases.getAll();
        model.addAttribute("productos", productos);

        return "producto";
    }

    @GetMapping("/formulario")
    String formulario(){
        return "form";
    }
    @PostMapping("/nuevo")
    String nuevo(Model model, Producto producto, @RequestParam(name = "id") Integer id, @RequestParam(name = "nombre") String nombre){

        producto = new Producto(id, nombre);
        this.productosUseCases.save(producto);
        List<Producto> productos = this.productosUseCases.getAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @RequestMapping("/productos/{id}")
    String find(Model model, @PathVariable Integer id){
        if(id == 1){
            model.addAttribute("producto", new Producto(1, "portatil"));
        }else{
            model.addAttribute("producto", new Producto(2, "torre"));
        }
        return "view";
    }

}
