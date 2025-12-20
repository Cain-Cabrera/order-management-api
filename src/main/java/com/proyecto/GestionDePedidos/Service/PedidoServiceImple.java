package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.DetallePedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoResponseDTO;
import com.proyecto.GestionDePedidos.Mapper.PedidoMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.Repository.PedidoRepository;
import com.proyecto.GestionDePedidos.Repository.ProductoRepository;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.DetalleDePedido;
import com.proyecto.GestionDePedidos.models.EstadoPedido;
import com.proyecto.GestionDePedidos.models.Pedido;
import com.proyecto.GestionDePedidos.models.Producto;
import com.proyecto.GestionDePedidos.validatorService.PedidoValidator;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cain
 */
@Service
public class PedidoServiceImple implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoValidator validatorPedido;
    private final PedidoMapper pedidoMapper;
    private final ProductoRepository productoRepository;
    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImple.class);

    public PedidoServiceImple(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, PedidoValidator validatorPedido,
            PedidoMapper pedidoMapper, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.validatorPedido = validatorPedido;
        this.pedidoMapper = pedidoMapper;
        this.productoRepository = productoRepository;
    }

    private Pedido findbyIdPedidoEntity(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El pedido no existe"));
    }

    @Override
    public PedidoResponseDTO createPedido(PedidoRequestDTO pedidoDto) {
        logger.trace("Se ejecuta createPedido para crear nuevo Pedido asociado a un cliente..");
        validatorPedido.validarAltaPedido(pedidoDto);
        Cliente clienteExistente = clienteRepository.findById(pedidoDto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado."));
        Pedido pedido = new Pedido();
        pedido.setCliente(clienteExistente);
        pedido.setFecha(LocalDate.now());
        pedido.setEstado(EstadoPedido.EN_PREPARACION);

        List<DetalleDePedido> detalles = new ArrayList<>();

        for (DetallePedidoRequestDTO detalleDto : pedidoDto.getDetalles()) {

            Producto producto = productoRepository.findById(detalleDto.getIdProducto())
                    .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

            if (producto.getStock() < detalleDto.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            DetalleDePedido detalle = new DetalleDePedido();
            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            producto.setStock(producto.getStock() - detalleDto.getCantidad());
            detalles.add(detalle);
        }

        pedido.setDetalleDelPedido(detalles);
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        return pedidoMapper.toResponse(pedidoGuardado);
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        logger.trace("Se ejecuta metodo FindAll para traer todos los pedidos..");
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoResponseDTO> listaResponse = pedidoMapper.toResponseList(pedidos);
        return listaResponse;
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        logger.trace("Se ejecuta metodo finbyId para traer Pedido por id..");
        Pedido PedidoExistente = findbyIdPedidoEntity(id);
        logger.info("Pedido con id: {} encontrado..", id);
        return pedidoMapper.toResponse(PedidoExistente);
    }

    @Override
    public void deletePedido(Long id) {
        logger.trace("Se ejecuta deletePedido para borrar Pedido..");
        if (id <= 0) {
            logger.error("ID inválido para borrar Pedido: {}", id);
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        Pedido pedido = findbyIdPedidoEntity(id);
        pedidoRepository.deleteById(id);
        logger.info("Pedido con id {} borrado con exito.. ", id);
    }
}
