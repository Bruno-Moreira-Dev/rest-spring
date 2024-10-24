package br.com.bruno.rest_spring.ProdutoService;

import br.com.bruno.rest_spring.entity.Pedido;
import br.com.bruno.rest_spring.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }
}
