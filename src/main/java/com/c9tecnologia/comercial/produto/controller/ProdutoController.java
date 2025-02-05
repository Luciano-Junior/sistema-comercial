package com.c9tecnologia.comercial.produto.controller;

import com.c9tecnologia.comercial.produto.dto.ProdutoInputDTO;
import com.c9tecnologia.comercial.produto.dto.ProdutoOutputDTO;
import com.c9tecnologia.comercial.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoOutputDTO>> listarTodosProdutos(){
        List<ProdutoOutputDTO> products = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProdutoOutputDTO> criarProduto(@Valid @RequestBody ProdutoInputDTO produto){
        ProdutoOutputDTO produtoCriado = produtoService.criarProduto(produto);
        return ResponseEntity.ok(produtoCriado);
    }



}
