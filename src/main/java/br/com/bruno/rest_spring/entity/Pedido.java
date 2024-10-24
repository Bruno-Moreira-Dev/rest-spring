package br.com.bruno.rest_spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;

    private LocalDateTime dataPedido;

    private String status;

    @ManyToMany
    @Fetch(FetchMode.SELECT)
    private Set<Produto> produtos;
}
