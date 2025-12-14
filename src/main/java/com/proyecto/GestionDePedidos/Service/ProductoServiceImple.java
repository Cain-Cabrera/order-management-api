package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.Mapper.ProductoMapper;
import com.proyecto.GestionDePedidos.Repository.ProductoRepository;
import com.proyecto.GestionDePedidos.models.Producto;
import com.proyecto.GestionDePedidos.validatorService.ProductoValidator;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cain
 */
@Service
public class ProductoServiceImple implements ProductoService{
    private final ProductoRepository productoRepository;
    private final ProductoValidator productoValidator;
    private final ProductoMapper productoMapper;
    private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImple.class);

    public ProductoServiceImple(ProductoRepository productoRepository, ProductoValidator productoValidator, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoValidator = productoValidator;
        this.productoMapper = productoMapper;
    }
    
    
    @Override
    public Producto createProducto(ProductoRequestDTO productoDTO) {
        logger.trace("Se ejecuta createProducto..");
        productoValidator.validarAlta(productoDTO);
        Producto producto = productoMapper.toEntity(productoDTO);
        logger.info("Producto creado con exito..");
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, ProductoRequestDTO productoDTO) {
       logger.trace("Se ejecuta updateProducto para actualizar producto existente..");
       productoValidator.validarAlta(productoDTO);
       Producto productoExistente = productoRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado.."));
       productoMapper.updateEntity(productoDTO, productoExistente);
       logger.info("Producto actualizado con exito..");
       return productoRepository.save(productoExistente);
    }

    @Override
    public void deleteProducto(Long id) {
       logger.trace("Se ejecuta deleteProducto..");

    if (id == null || id <= 0) {
        logger.error("ID inválido para borrar Producto: {}", id);
        throw new IllegalArgumentException("El id debe ser mayor a 0");
    }

    Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

    productoRepository.delete(producto);
    logger.info("Producto con id {} borrado con éxito..", id);
    }

    @Override
    public List<Producto> findAll() {
        logger.trace("Se ejecuta findAll para listar productos..");
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
       logger.trace("Se ejecuta findById para buscar producto..");
    if (id == null || id <= 0) {
        logger.error("ID inválido para buscar Producto: {}", id);
        throw new IllegalArgumentException("El id debe ser mayor a 0");
    }
    return productoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
    }
    
}
