package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.repository.RelatorioRepository;
import dto.TotalCompradoPorFornecedor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    public List<TotalCompradoPorFornecedor> pesquisarTotalCompradoPorFornecedor() {
        return repository.pesquisarTotalCompradoPorFornecedor();
    }
}
