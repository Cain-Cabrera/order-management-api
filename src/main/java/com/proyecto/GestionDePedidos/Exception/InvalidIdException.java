package com.proyecto.GestionDePedidos.Exception;
/**
 *
 * @author Cain
 */
public class InvalidIdException extends DomainException {
    
    public InvalidIdException(String entity, Object id) {
        super("Id inválido para " + entity + ": " + id);
    }
}
