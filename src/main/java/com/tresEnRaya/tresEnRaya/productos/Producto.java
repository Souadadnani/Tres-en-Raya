package com.tresEnRaya.tresEnRaya.productos;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private Integer id;
    private String nombre;
    private List<Integer> productos;

    public Producto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }
}
