package com.company;

public class Produto {
    enum departamento { informatica, livro, games, moveis };
    private int codProd;
    private String nome;
    private departamento dep;
    private double preco;
    private double frete;
    private int numParcelas;
    private String descricao;


    public Produto(int codProd, String nome, departamento dep, double preco, double frete, int numParcelas, String descricao ){
        this.codProd = codProd;
        this.nome = nome;
        this.dep = dep;
        this.preco = preco;
        this.frete = frete;
        this.numParcelas = numParcelas;
        this.descricao = descricao;
    }

    public departamento getDep (){
        return this.dep;
    }

    public double getPreco (){
        return this.preco;
    }

    public double getFrete (){
        return this.preco;
    }

    public int getNParcelas (){
        return this.numParcelas;
    }

    public String exibirInfos(){
        String temp = "\n\rCod.: " + Integer.toString(this.codProd) + " -- " ;
        temp = temp + this.nome + "\n\r" + "preço: R$" + Double.toString(this.preco ) + " ou em " ;
        temp = temp + Integer.toString(this.numParcelas) + "X de " + Double.toString( (this.preco/this.numParcelas));
        temp = temp + "\n\rFrete: " + Double.toString( this.frete ) + "\n\r";
        temp = temp + this.descricao + "\n\r\n\r";
        return temp;
    }

    public String exibirResumo(){
        String temp = "\n\r" + Integer.toString(this.codProd) + " -- " ;
        temp = temp + this.nome + ":" + " R$" + Double.toString(this.preco );
        return temp;
    }

}

