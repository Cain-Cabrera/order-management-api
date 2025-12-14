package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.models.Producto;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface ProductoService {
    Producto createProducto(ProductoRequestDTO entidad);
    Producto updateProducto(Long id, ProductoRequestDTO entidad);
    void deleteProducto (Long id);  
    List<Producto> findAll();
    Producto findById(Long id);
}
