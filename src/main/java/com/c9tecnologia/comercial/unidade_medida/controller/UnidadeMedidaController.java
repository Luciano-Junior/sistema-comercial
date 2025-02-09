package com.c9tecnologia.comercial.unidade_medida.controller;

import com.c9tecnologia.comercial.produto.dto.ProdutoOutputDTO;
import com.c9tecnologia.comercial.unidade_medida.dto.UnidadeMedidaInputDTO;
import com.c9tecnologia.comercial.unidade_medida.dto.UnidadeMedidaOutputDTO;
import com.c9tecnologia.comercial.unidade_medida.model.UnidadeMedida;
import com.c9tecnologia.comercial.unidade_medida.service.UnidadeMedidaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidade-medida")
public class UnidadeMedidaController {
    UnidadeMedidaService unidadeMedidaService;

    public UnidadeMedidaController(UnidadeMedidaService unidadeMedidaService){
        this.unidadeMedidaService = unidadeMedidaService;
    }

    @GetMapping
    public ResponseEntity<List<UnidadeMedidaOutputDTO>> listarUnidadeMedida(){
        List<UnidadeMedidaOutputDTO> unidadeMedidas = unidadeMedidaService.listarUnidadeMedidas();
        return ResponseEntity.ok(unidadeMedidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeMedidaOutputDTO> buscarUnidadePorId(@PathVariable Long id){
        UnidadeMedidaOutputDTO unidadeMedida = unidadeMedidaService.buscarUnidadePorId(id);
        return ResponseEntity.ok(unidadeMedida);
    }

    @PostMapping
    public ResponseEntity<UnidadeMedidaOutputDTO> criarUnidadeMedida(@Valid @RequestBody UnidadeMedidaInputDTO unidadeInput){
        return ResponseEntity.ok(unidadeMedidaService.criarUnidadeMedida(unidadeInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeMedidaOutputDTO> atualizarUnidadeMedida(@PathVariable Long id, @RequestBody UnidadeMedidaInputDTO unidadeInput){
        return ResponseEntity.ok(unidadeMedidaService.atualiarUnidadeMedida(id, unidadeInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidade(Long id){
        unidadeMedidaService.deleteUnidade(id);
        return ResponseEntity.noContent().build();
    }
}
