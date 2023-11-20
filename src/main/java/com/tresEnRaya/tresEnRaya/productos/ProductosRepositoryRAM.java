package com.tresEnRaya.tresEnRaya.productos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductosRepositoryRAM implements ProductosRepository{

    private List<Producto> productos;

    public ProductosRepositoryRAM(){
        this.productos = new ArrayList<>(Arrays.asList(new Producto(1, "teclado"), new Producto(2, "raton"),
                new Producto(3, "monitor")));
    }
    @Override
    public List<Producto> getAll() {
        return this.productos;
    }

    @Override
    public Producto save(Producto producto) {
        this.productos.add(producto);
        return this.find(producto.getId());
    }

    @Override
    public Producto find(Integer id){
        for (Producto producto: this.getAll()){
            if (producto.getId() == id)
                return producto;
        }
        return null;
    }
}
