
package com.proyecto.GestionDePedidos.Exception;
/**
 *
 * @author Cain
 */
public class ProductoNotFoundException extends DomainException {
    
    public ProductoNotFoundException(Long id) {
        super("Producto con id: " + id + " no encontrado");
    }
}
