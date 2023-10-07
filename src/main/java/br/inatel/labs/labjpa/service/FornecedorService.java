package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor salvar(Fornecedor f) {
        return repository.save(f);
    }

    public Optional<Fornecedor> buscarPeloId(Long id) {
        return repository.findById(id);
    }

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public void remover(Fornecedor f) {
        repository.delete(f);
    }
}
