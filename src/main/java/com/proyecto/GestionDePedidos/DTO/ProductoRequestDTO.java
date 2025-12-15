package com.proyecto.GestionDePedidos.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
public class ProductoRequestDTO {
    @NotBlank
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String nombre;
   
    private double precio;
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    @DecimalMax(value = "1000000.00", message = "El precio supera el máximo permitido")
     
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    public ProductoRequestDTO(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}
