package com.tresEnRaya.tresEnRaya.productos;

import java.util.List;

public class ProductosUseCases {

    private ProductosRepository productosRepository;

    public ProductosUseCases(ProductosRepository productosRepository){
        this.productosRepository = productosRepository;
    }

    public List<Producto> getAll(){
        return this.productosRepository.getAll();
    }

    public Producto save(Producto producto){
        return this.productosRepository.save(producto);
    }
    public Producto find(Integer id){
        return this.productosRepository.find(id);
    }
}
