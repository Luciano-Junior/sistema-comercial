package com.c9tecnologia.comercial.produto.repository;

import com.c9tecnologia.comercial.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
