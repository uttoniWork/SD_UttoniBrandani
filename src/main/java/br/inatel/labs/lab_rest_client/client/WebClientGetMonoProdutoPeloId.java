package br.inatel.labs.lab_rest_client.client;


import br.inatel.labs.lab_rest_client.client.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProdutoPeloId {

    public static void main(String[] args) {
        try {
            final Mono<ProdutoDTO> monoProduto = WebClient.create(Constantes.BASE_URL)
                    .get()
                    .uri("/produto/2")
                    .retrieve()
                    .bodyToMono(ProdutoDTO.class);

            monoProduto.subscribe();
            final ProdutoDTO produtoRetornado = monoProduto.block();

            System.out.println("Produto:");
            System.out.println(produtoRetornado);
        } catch (WebClientResponseException e) {
            System.out.println("Status code:" + e.getStatusCode());
            System.out.println("Message:" + e.getMessage());
        }
    }
}