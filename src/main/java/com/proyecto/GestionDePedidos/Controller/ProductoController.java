package com.proyecto.GestionDePedidos.Controller;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;
import com.proyecto.GestionDePedidos.Service.ProductoService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Cain
 */
@RequestMapping("/productos")
@RestController
public class ProductoController {

    private final ProductoService productoService;
    private final Logger logger = LoggerFactory.getLogger(ProductoController.class);
    
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> createProducto(@Valid @RequestBody ProductoRequestDTO productoRequest) {
        logger.trace("Se ejecuta POST /productos");
        ProductoResponseDTO response = productoService.createProducto(productoRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> findAll() {
        logger.trace("Se ejecuta GET /productos");
        List<ProductoResponseDTO> response = productoService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> findById(@PathVariable Long id) {
        logger.trace("Se ejecuta GET /productos/{}", id);
        ProductoResponseDTO response = productoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> updateProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequestDTO productoRequest) {
        logger.trace("Se ejecuta PUT /productos/{}", id);
        ProductoResponseDTO response = productoService.updateProducto(id, productoRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        logger.trace("Se ejecuta DELETE /productos/{}", id);
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}

