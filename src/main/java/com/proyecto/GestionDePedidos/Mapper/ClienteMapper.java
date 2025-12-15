package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
import org.springframework.stereotype.Component;
/**
 *
 * @author Cain
 */
@Component
public class ClienteMapper {
    
    public Cliente mapperCreateEntidad(ClienteDTO clientedto) {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNombre(clientedto.getNombre());
        clienteEntity.setApellido(clientedto.getApellido());
        clienteEntity.setDni(clientedto.getDni());
        return clienteEntity;
    }
    
    public void mapperUpdateEntidad(ClienteDTO dto, Cliente clienteExistente) {
        clienteExistente.setNombre(dto.getNombre());
        clienteExistente.setApellido(dto.getApellido());
        clienteExistente.setDni(dto.getDni());
    }
    
    public ClienteResponseDTO toResponse(Cliente cliente) {
        ClienteResponseDTO clienteReponse = new ClienteResponseDTO();
        clienteReponse.setId(cliente.getIdCliente());
        clienteReponse.setApellido(cliente.getApellido());
        clienteReponse.setNombre(cliente.getNombre());
        return clienteReponse;
    }
}
