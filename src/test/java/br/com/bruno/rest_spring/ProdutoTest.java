package br.com.bruno.rest_spring;

import br.com.bruno.rest_spring.ProdutoService.ProdutoService;
import br.com.bruno.rest_spring.entity.Produto;
import br.com.bruno.rest_spring.exception.ProductPriceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void verificaValorNegativoNoProduto() {
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(-10.0);

        Assertions.assertThrows(ProductPriceException.class, () -> produtoService.save(produto));
    }
}
