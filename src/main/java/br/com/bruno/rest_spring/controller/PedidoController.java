package br.com.bruno.rest_spring.controller;

import br.com.bruno.rest_spring.ProdutoService.PedidoService;
import br.com.bruno.rest_spring.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/save")
    public ResponseEntity<Pedido> salvaPedido(@RequestBody Pedido pedido) {
        pedido  = service.save(pedido);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscaPedido(@PathVariable Long id) {
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/busca-todos")
    public ResponseEntity<List<Pedido>> buscaTodosPedidos() {
        List<Pedido> pedidos = service.findAll();
        return ResponseEntity.ok().body(pedidos);
    }
}
