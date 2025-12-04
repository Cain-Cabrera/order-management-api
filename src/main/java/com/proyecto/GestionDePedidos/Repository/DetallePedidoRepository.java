package com.proyecto.GestionDePedidos.Repository;

import com.proyecto.GestionDePedidos.models.DetalleDePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Cain
 */
@Repository
public interface DetallePedidoRepository extends JpaRepository<DetalleDePedido, Long>{}
