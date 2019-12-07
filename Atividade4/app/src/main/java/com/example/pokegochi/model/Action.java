package com.example.pokegochi.model;

public class Action
{
    public String nome;
    public String tipo;
    public int valor;

    public Action(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome;
    }
}
