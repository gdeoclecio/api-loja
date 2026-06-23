package br.com.loja_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja_api.entity.Produto;
import br.com.loja_api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;



    //Post
    @Transactional
    public Produto inserir(Produto produto){
       return produtoRepository.save(produto);
    }
    //Get all
  
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }
    // Get por id
    
    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado com o id" + id));
    }
    @Transactional
    public Produto atualizar(Long id, Produto produtoAtualizado){
       produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado por id:" + id));

        produtoAtualizado.setId(id);
        return produtoRepository.save(produtoAtualizado);
    }
    @Transactional
    public void deletar(Long id){
        if(!produtoRepository.existsById(id)){
            throw new RuntimeException("Não é possivel deletar, Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

}
