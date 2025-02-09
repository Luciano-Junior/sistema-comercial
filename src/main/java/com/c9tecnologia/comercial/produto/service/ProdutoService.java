package com.c9tecnologia.comercial.produto.service;

import com.c9tecnologia.comercial.produto.dto.ProdutoInputDTO;
import com.c9tecnologia.comercial.produto.dto.ProdutoOutputDTO;
import com.c9tecnologia.comercial.produto.model.Produto;
import com.c9tecnologia.comercial.produto.repository.ProdutoRepository;
import com.c9tecnologia.comercial.unidade_medida.model.UnidadeMedida;
import com.c9tecnologia.comercial.unidade_medida.repository.UnidadeMedidaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final UnidadeMedidaRepository unidadeMedidaRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, UnidadeMedidaRepository unidadeMedidaRepository, ModelMapper modelMapper){
        this.produtoRepository = produtoRepository;
        this.unidadeMedidaRepository = unidadeMedidaRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProdutoOutputDTO> listarTodosProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> {
                    ProdutoOutputDTO dto = modelMapper.map(produto, ProdutoOutputDTO.class);
                    dto.setUnidadeMedidaNome(produto.getUnidadeMedida().getNome());
                    return dto;
                })
                .toList();
    }

    @Transactional
    public ProdutoOutputDTO criarProduto(ProdutoInputDTO produto){
        UnidadeMedida unidadeMedida = unidadeMedidaRepository.findById(produto.getUnidadeMedidaId())
                .orElseThrow(()-> new EntityNotFoundException("Unidade de medida não encontrada!"));

        // Converte DTO para entidade Produto
        Produto produtoMapper = modelMapper.map(produto, Produto.class);
        //seta unidade de medida
        produtoMapper.setUnidadeMedida(unidadeMedida);
        // Salva no Banco
        Produto produtoSalvo = produtoRepository.save(produtoMapper);
        return modelMapper.map(produtoSalvo, ProdutoOutputDTO.class);
    }

    public ProdutoOutputDTO buscarPorId(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Produto não encontrado"));
        return modelMapper.map(produto, ProdutoOutputDTO.class);
    }

    @Transactional
    public ProdutoOutputDTO atualizarProduto(Long id, ProdutoInputDTO produtoInput){
        UnidadeMedida unidadeMedida = unidadeMedidaRepository.findById(produtoInput.getUnidadeMedidaId())
                .orElseThrow(()-> new EntityNotFoundException("Unidade de medida não encontrada!"));
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Produto não encontrado"));

        produto.setUnidadeMedida(unidadeMedida);
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
