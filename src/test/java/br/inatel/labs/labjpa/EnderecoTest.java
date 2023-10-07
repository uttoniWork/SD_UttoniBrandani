package br.inatel.labs.labjpa;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoTest {

    @Autowired
    private EnderecoService service;

    @Test
    public void testarUUUIDGeradoPeloJPAListener() {
        Endereco e = new Endereco();
        e.setRua("Rua teste");
        e.setNumero("123");
        e.setCidade("Santa Rita");
        e.setUf("MG");

        e = service.salvar(e);
        System.out.print(e);
    }
}
