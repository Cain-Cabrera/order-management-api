package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import com.proyecto.GestionDePedidos.Mapper.ClienteMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.Validator.ClienteValidator;
import com.proyecto.GestionDePedidos.models.Cliente;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 *
 * @author Cain
 */
@Service
public class ClienteServiceImple implements ClienteService{
    
    private final ClienteRepository clienteRepository;
    private final ClienteValidator clienteValidator;
    private final ClienteMapper clienteMapper;
    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImple.class);
    
    public ClienteServiceImple(ClienteRepository clienteRepository,ClienteValidator clienteValidator,ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteValidator = clienteValidator;
        this.clienteMapper = clienteMapper;
    }
   
    
    
    @Override
    public Cliente createCliente(ClienteDTO clienteDto) {
        logger.trace("Se ejecuta metodo createCliente para dar de alta una entidad Cliente");
        clienteValidator.validarAlta(clienteDto);
        Cliente cliente = clienteMapper.mapToEntity(clienteDto);
        logger.info("Cliente dado de alta con exito..");
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, ClienteDTO entidad) {
        return null;
    }

    @Override
    public void deleteCliente(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
