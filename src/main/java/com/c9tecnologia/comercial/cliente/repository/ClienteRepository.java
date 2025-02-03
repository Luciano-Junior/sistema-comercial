package com.c9tecnologia.comercial.cliente.repository;

import com.c9tecnologia.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
