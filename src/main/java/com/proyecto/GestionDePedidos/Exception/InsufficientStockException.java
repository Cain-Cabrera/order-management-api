package com.proyecto.GestionDePedidos.Exception;
/**
 *
 * @author Cain
 */
public class InsufficientStockException extends DomainException {
    
    public InsufficientStockException(String entity) {
        super("Producto: " + entity + " sin stock..");
    }
    
}
