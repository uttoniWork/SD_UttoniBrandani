package br.inatel.labs.lab_rest_server.service;


import br.inatel.labs.lab_rest_server.model.Produto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<Produto>();

    @PostConstruct
    private void setup() {
        final Produto p1 = new Produto(1L, " Furadeira", new BigDecimal(230.00));
        final Produto p2 = new Produto(2L, " Serra Circular", new BigDecimal(500.00));
        final Produto p3 = new Produto(3L, " Parafusadeira", new BigDecimal(400.00));

        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
    }

    public List<Produto> findAll() {
        return this.produtos;
    }

    public Optional<Produto> findById(Long id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public Produto create(Produto p) {
        final long idGerada = new Random().nextLong();
        p.setId(idGerada);

        produtos.add(p);

        return p;
    }

    public void update(Produto p) {
        produtos.remove(p);
        produtos.add(p);
    }

    public void remove(Produto p) {
        produtos.remove(p);
    }
}
