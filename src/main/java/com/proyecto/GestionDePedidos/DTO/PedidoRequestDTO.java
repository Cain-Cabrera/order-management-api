package com.proyecto.GestionDePedidos.DTO;

import com.proyecto.GestionDePedidos.models.EstadoPedido;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
public class PedidoRequestDTO {
    
    @NotNull
    private LocalDate fecha;
    @NotNull
    private EstadoPedido estado;
    @NotNull
    private Long idCliente;
    
    public PedidoRequestDTO() {
    }
    
    public PedidoRequestDTO(LocalDate fecha, EstadoPedido estado, Long idCliente) {
        this.fecha = fecha;
        this.estado = estado;
        this.idCliente = idCliente;
    }
}
