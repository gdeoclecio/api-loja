package br.com.loja_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_api.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
