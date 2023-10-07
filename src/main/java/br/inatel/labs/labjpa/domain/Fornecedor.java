package br.inatel.labs.labjpa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String razaoSocial;

    @ManyToMany
    private List<Produto> listaProduto;

    public Long getId() {
        return id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }
}
