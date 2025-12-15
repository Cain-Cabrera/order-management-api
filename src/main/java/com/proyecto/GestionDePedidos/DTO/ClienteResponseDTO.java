package com.proyecto.GestionDePedidos.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
