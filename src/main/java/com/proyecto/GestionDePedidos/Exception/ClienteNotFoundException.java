package com.proyecto.GestionDePedidos.Exception;
/**
 *
 * @author Cain
 */
public class ClienteNotFoundException extends DomainException {
    
    public ClienteNotFoundException(Long id) {
        super("Cliente con id: " + id + " no encontrado.");
    } 
}
