package com.c9tecnologia.comercial.cliente.controller;

import com.c9tecnologia.comercial.cliente.dto.ClienteInputDTO;
import com.c9tecnologia.comercial.cliente.model.Cliente;
import com.c9tecnologia.comercial.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody ClienteInputDTO clienteInputDTO) {
        System.out.println("Recebido no controlador: " + clienteInputDTO);
        Cliente novoCliente = clienteService.saveCliente(clienteInputDTO);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.updateCliente(id, cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
