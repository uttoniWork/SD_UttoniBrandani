package br.inatel.labs.server;


import br.inatel.labs.lab_rest_server.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProdutoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void dadoProdutoIdInvalido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNotFound() {
        final Long produtoIdInvalido = 99L; //por que 2L e nao 1L?

        webTestClient.delete()
                .uri("/produto/" + produtoIdInvalido)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void dadoProdutoIdValido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNoContent() {
        final Long produtoIdValido = 2L; //por que 2L e nao 1L? pra nao quebrar o primeiro teste

        webTestClient.delete()
                .uri("/produto/" + produtoIdValido)
                .exchange()
                .expectStatus()
                .isNoContent();
    }

    @Test
    void dadoProdutoExistente_quandoPutProduto_entaoRespondeComStatusNoContent() {
        final Produto produtoExistente = new Produto();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("Furadeira a bateria");
        produtoExistente.setPreco(new BigDecimal(800.00));

        webTestClient.put()
                .uri("/produto")
                .bodyValue(produtoExistente)
                .exchange()
                .expectStatus()
                .isNoContent();
    }


    @Test
    void dadoNovoProduto_quandoPostProduto_entaoRespondeComStatusCreatedEProdutoValido() {
        final Produto novoProduto = new Produto();
        novoProduto.setDescricao("Tupia de Mesa");
        novoProduto.setPreco(new BigDecimal(9000.00));

        final Produto produtoRespondido = webTestClient.post()
                .uri("/produto")
                .bodyValue(novoProduto)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(Produto.class)
                .returnResult()
                .getResponseBody();

        assertThat(produtoRespondido).isNotNull();
        assertThat(produtoRespondido.getId()).isNotNull();
    }

    @Test
    void dadoProdutoIdInvalido_quandoGetProdutoPeloId_entaoRespondeComStatusNotFound() {
        final Long idInvalido = 99L;

        webTestClient.get()
                .uri("/produto/" + idInvalido)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void dadoProdutoIdValido_quandoGetProdutoPeloId_entaoRespondeComProdutoValido() {
        Long produtoIdValido = 1L;

        final Produto produtoRespondido = webTestClient.get()
                .uri("/produto/" + produtoIdValido)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Produto.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(produtoRespondido);
        assertEquals(produtoRespondido.getId(), produtoIdValido);
    }

    @Test
    void deveListarProdutos() {
        webTestClient.get()
                .uri("/produto")
                .exchange()
                .expectStatus()
                .isOk() //status is OK?
                .expectBody()
                .returnResult() //retornou resultado?
        ;
    }
}
