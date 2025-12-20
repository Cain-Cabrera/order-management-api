package com.proyecto.GestionDePedidos.Controller;

import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.Service.ClienteServiceImple;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Cain
 */
@RestController
public class ClienteController {
    private final ClienteServiceImple clienteService;
    
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    public ClienteController(ClienteServiceImple clienteService) {
        this.clienteService = clienteService;
    }
    
    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponseDTO> createCliente(@Valid @RequestBody ClienteRequestDTO clienteRequest) {
        logger.trace("Se ejecuta endpoint 'createCliente'..");
        ClienteResponseDTO clienteResponse = clienteService.createCliente(clienteRequest);
        return new ResponseEntity(clienteResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponseDTO> findByid(@PathVariable Long id) {
        logger.trace("Se ejecuta metodo findByid para buscar un cliente via id");
        ClienteResponseDTO response = clienteService.findById(id);
        return new ResponseEntity(response, HttpStatus.OK); 
    }
    
    @PutMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@Valid @RequestBody ClienteRequestDTO clienteRequest,@PathVariable Long id) {
        logger.trace("Se ejecuta updateCliente para modificar cliente existente..");
        ClienteResponseDTO clienteResponse = clienteService.updateCliente(id, clienteRequest);
        return new ResponseEntity(clienteResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/cliente/{id}") 
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        logger.trace("Se ejecuta metodo deleteCliente..");
        clienteService.deleteCliente(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
