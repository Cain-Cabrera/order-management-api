
package com.proyecto.GestionDePedidos.Exception;
/**
 *
 * @author Cain
 */
public class PedidoNotFoundException extends DomainException {
    
    public PedidoNotFoundException(Long id) {
        super("Pedido con id: " + id + " no encontrado");
    }
    
}
