package com.company;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String cep;
    private String email;

    public Cliente(String CPF, String nome, String endereco, String CEP, String email) {
        this.cpf = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = CEP;
        this.email = email;
    }

    public String  resumoCliente() {
        String temp = "Nome: " + this.nome +"\nCPF: " + this.cpf + "\nEndereço: " + this.endereco+ "\nCEP: " + this.cep + "\nEmail: " + this.email;
        return temp;
    }


}
