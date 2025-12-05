package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
/**
 *
 * @author Cain
 */
public class ClienteMapper {
    
    public Cliente mapToEntity(ClienteDTO clientedto) {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNombre(clientedto.getNombre());
        clienteEntity.setApellido(clientedto.getApellido());
        clienteEntity.setDni(clientedto.getDni());
        
        return clienteEntity;
    }
    
}
