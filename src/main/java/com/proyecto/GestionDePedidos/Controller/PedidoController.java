package com.proyecto.GestionDePedidos.Controller;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoResponseDTO;
import com.proyecto.GestionDePedidos.Service.PedidoService;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Cain
 */
@RequestMapping("/pedidos")
@RestController
public class PedidoController {
    private final PedidoService pedidoService;
    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> createPedido(@Valid @RequestBody PedidoRequestDTO pedidoRequest) {
        logger.trace("Se ejecuta createPedido para dar de alta entidad pedido..");
        PedidoResponseDTO response = pedidoService.createPedido(pedidoRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll() {
        logger.trace("Se ejectua findAll para traer todos los pedidos existentes..");
        List<PedidoResponseDTO> response = pedidoService.findAll();
        return new ResponseEntity(response, HttpStatus.OK);
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id) {
        logger.info("Se ejecuta finByid para traer entidad via id");
        PedidoResponseDTO response = pedidoService.findById(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
            
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        logger.info("Se ejecuta metodo deletePedido para borrar pedido existente..");
        pedidoService.deletePedido(id);
         return ResponseEntity.noContent().build();
    }  
}
