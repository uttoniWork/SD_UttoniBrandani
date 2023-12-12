package br.inatel.labs.lab_rest_client.client;

import br.inatel.labs.lab_rest_client.client.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

public class WebClientPostProduto {

    public static void main(String[] args) {
        final ProdutoDTO novoProduto = new ProdutoDTO();
        novoProduto.setDescricao("Martelo");
        novoProduto.setPreco(new BigDecimal(25.00));

        ProdutoDTO produtoCriado = WebClient.create(Constantes.BASE_URL)
                .post()
                .uri("/produto")
                .bodyValue(novoProduto)
                .retrieve()
                .bodyToMono(ProdutoDTO.class)
                .block();

        System.out.println("Produto criado:");
        System.out.println(produtoCriado);
    }
}
