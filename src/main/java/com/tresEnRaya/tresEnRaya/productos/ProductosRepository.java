package com.tresEnRaya.tresEnRaya.productos;

import java.util.List;

public interface ProductosRepository {

    List<Producto> getAll();

    Producto save(Producto producto);

    Producto find(Integer id);
}
