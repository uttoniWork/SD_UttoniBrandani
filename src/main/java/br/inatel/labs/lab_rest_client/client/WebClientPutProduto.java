package br.inatel.labs.lab_rest_client.client;

import br.inatel.labs.lab_rest_client.client.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientPutProduto {

    public static void main(String[] args) {
        final ProdutoDTO produtoExistente = new ProdutoDTO();
        produtoExistente.setId( 1L );
        produtoExistente.setDescricao("Furadeira a bateria!");

        ResponseEntity<Void> responseEntity = WebClient.create(Constantes.BASE_URL)
                .put()
                .uri("/produto")
                .bodyValue(produtoExistente)
                .retrieve()
                .toBodilessEntity()
                .block();

        System.out.println("Produto atualizado:");
        System.out.println("Status da resposta " + responseEntity.getStatusCode() );
    }
}
