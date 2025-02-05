package com.c9tecnologia.comercial.produto.service;

import com.c9tecnologia.comercial.produto.dto.ProdutoInputDTO;
import com.c9tecnologia.comercial.produto.dto.ProdutoOutputDTO;
import com.c9tecnologia.comercial.produto.model.Produto;
import com.c9tecnologia.comercial.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper){
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProdutoOutputDTO> listarTodosProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoOutputDTO.class))
                .toList();
    }

    @Transactional
    public ProdutoOutputDTO criarProduto(ProdutoInputDTO produto){
        Produto produtoMapper = modelMapper.map(produto, Produto.class);
        Produto produtoSalvo = produtoRepository.save(produtoMapper);
        return modelMapper.map(produtoSalvo, ProdutoOutputDTO.class);
    }

    public ProdutoOutputDTO buscarPorId(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Produto não encontrado"));
        return modelMapper.map(produto, ProdutoOutputDTO.class);
    }

    @Transactional
    public ProdutoOutputDTO atualizarProduto(Long id, ProdutoInputDTO produtoInput){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Produto não encontrado"));

        modelMapper.map(produtoInput, produto);

        Produto produtoAtualizado = produtoRepository.save(produto);
        return modelMapper.map(produtoAtualizado, ProdutoOutputDTO.class);
    }

    @Transactional
    public void deleteProduto(Long id){
        if (!produtoRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto não encontrado");
        }

        produtoRepository.deleteById(id);
    }
}
