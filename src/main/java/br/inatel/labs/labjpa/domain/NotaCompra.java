package br.inatel.labs.labjpa.domain;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class NotaCompra {
    private Long id;
    private LocalDate dataEmissao;
    private Fornecedor fornecedor;
    private List<NotaCompraItem> listaNotaCompraItem;

    public BigDecimal getCalculoTotalNota(){
        BigDecimal totalNota = listaNotaCompraItem.stream()
                .map(i -> i.getCalculoTotalItem())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalNota;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public List<NotaCompraItem> getListaNotaCompraItem() {
        return listaNotaCompraItem;
    }
}
