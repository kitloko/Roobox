package br.com.roobox.chatbot;

import lombok.Data;
@Data
public class Pedido {

    private String codProduto;
    private Integer idCliente;
    private int quantidade;
}
