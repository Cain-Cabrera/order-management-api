package com.proyecto.GestionDePedidos.Exception;

/**
 *
 * @author Cain
 */
public abstract class DomainException extends RuntimeException {
    
    public DomainException(String message) {
        super(message);
    }
}


