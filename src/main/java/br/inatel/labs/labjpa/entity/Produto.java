package br.inatel.labs.labjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String descricao;

    @ManyToMany(mappedBy = "listaProduto")
    private List<Fornecedor> listaFornecedor;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }
}
