package br.com.bruno.rest_spring.ProdutoService;

import br.com.bruno.rest_spring.entity.Produto;
import br.com.bruno.rest_spring.exception.ProductNullException;
import br.com.bruno.rest_spring.exception.ProductPriceException;
import br.com.bruno.rest_spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) throws ProductNullException, ProductPriceException {
        if (Objects.isNull(produto.getNome()) || Objects.isNull(produto.getPreco()))
            throw new ProductNullException();
        if (produto.getPreco() < 0)
            throw new ProductPriceException();
        return repository.save(produto);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }
}
