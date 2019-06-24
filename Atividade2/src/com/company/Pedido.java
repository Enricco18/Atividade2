package com.company;

public class Pedido {
    Cliente cli;
    Carrinho carrinho;

    public Pedido(Cliente cli, Carrinho carrinho) {
        this.cli = cli;
        this.carrinho = carrinho;
    }

    public String resumoPedido(){
        String temp = cli.resumoCliente() +"\n" + carrinho.retornarResumo() + "PEDIDO FINALIZADO! E-mail enviado.";


        return temp;
    };
}
