package com.proyecto.GestionDePedidos.Service;


import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface ClienteService {
    Cliente createCliente(ClienteDTO entidad);
    Cliente updateCliente(Long id, ClienteDTO entidad);
    void deleteCliente (Long id);  
    List<Cliente> findAll();
    Cliente findById(Long id);
}
