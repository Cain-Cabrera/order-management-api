package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.models.Producto;

/**
 *
 * @author Cain
 */
public class ProductoMapper {
    
    public Producto toEntity(ProductoRequestDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        return producto;
    }

    
    public void updateEntity(ProductoRequestDTO productoDTO, Producto productoExistente) {
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setPrecio(productoDTO.getPrecio());
        productoExistente.setStock(productoDTO.getStock());
    }
}
    

