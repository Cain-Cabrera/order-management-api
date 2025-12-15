package com.proyecto.GestionDePedidos.DTO;
/**
 *
 * @author Cain
 */
public class DetallePedidoReponseDTO {
    private ProductoResponseDTO producto;
    private Integer cantidad;
    private Double precioUnitario;

    public DetallePedidoReponseDTO() {
    }

    public DetallePedidoReponseDTO(ProductoResponseDTO producto,Integer cantidad,Double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
