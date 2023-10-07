package br.inatel.labs.labjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class NotaCompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorCompraProduto;
    private Integer quantidade;
    private NotaCompra notaCompra;
    private Produto produto;
    public BigDecimal getCalculoTotalItem() {
        return valorCompraProduto;
    }
}
