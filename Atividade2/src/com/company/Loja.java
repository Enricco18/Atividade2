package com.company;

public class Loja {

    public Produto[] produtos;

    public Loja(){

        this.produtos = new Produto[21];

        this.produtos[0] = new Produto(0,"Metal Gear", Produto.departamento.games, 125.0, 12.0, 3, "Jogo muito bom");
        this.produtos[1] = new Produto(1,"Cadeira reclinavel", Produto.departamento.moveis, 240, 23.0, 10, "Cadeirinha show de bola");
        this.produtos[2] = new Produto(2,"Mesa para PC - Tabajara", Produto.departamento.moveis, 890.0, 50.0, 8, "Mesa meia boca, mas pra quem é ta bom");
        this.produtos[3] = new Produto(3,"Memória Ram - 4GB 1666", Produto.departamento.informatica, 200.0, 0.0, 5, "Memória RAM supimpa.");
        this.produtos[4] = new Produto(4,"Borderlands 2", Produto.departamento.games, 65.0, 12.0, 3, "Jogo muito bom!");
        this.produtos[5] = new Produto(5,"Monitor Benq - 24'", Produto.departamento.informatica, 1825.0, 42.0, 12, "Monitor legal.");
        this.produtos[6] = new Produto(6,"Castlevania - Curse of Darkness", Produto.departamento.games, 112.0, 10.0, 3, "Jogo TOP.");
        this.produtos[7] = new Produto(7,"Java I", Produto.departamento.livro, 720.0, 0.0, 5, "Aprenda Java!");
        this.produtos[8] = new Produto(8,"Java II", Produto.departamento.livro, 721.0, 0.0, 5, "Aprenda mais um pouco de Java!");
        this.produtos[9] = new Produto(9,"Java III", Produto.departamento.livro, 722.0, 0.0, 5, "Ja deu de Java!");
        this.produtos[10] = new Produto(10,"Java IV", Produto.departamento.livro, 723.0, 0.0, 5, "Esse livro só esta te enrolando.!");
        this.produtos[11] = new Produto(11,"Metal Gear II", Produto.departamento.games, 52.0, 12.0, 4, "Bom! Mas não tanto quanto o primeiro.");
        this.produtos[12] = new Produto(12,"A orientação a objeto e você", Produto.departamento.livro, 12.0, 0.0, 5, "POO é vida!");
        this.produtos[13] = new Produto(13,"L4D", Produto.departamento.games, 43.0, 12.0, 3, "Cuidado com o Boomer.");
        this.produtos[14] = new Produto(14,"SSD - Samsung 480 GB", Produto.departamento.informatica, 750.0, 8.0, 12, "Melhora o desempenho do seu computador!");
        this.produtos[15] = new Produto(15,"Borderlands 2", Produto.departamento.informatica, 65.0, 12.0, 3, "Jogo muito bom!");
        this.produtos[16] = new Produto(16,"Sofá de couro - 3 lugares", Produto.departamento.moveis, 3890.0, 150.0, 12, "Sofá do bom.");
        this.produtos[17] = new Produto(17,"Sofá de couro - 2 lugares", Produto.departamento.moveis, 2190.0, 150.0, 12, "Sofá do bombom.");
        this.produtos[18] = new Produto(18,"Cama casal", Produto.departamento.moveis, 990.0, 50.0, 8, "Uma simples cama.");
        this.produtos[19] = new Produto(19,"Vigillant 8 - 2nd offense", Produto.departamento.games, 120.0, 12.0, 3, "Um primor que não volta mais.");
        this.produtos[20] = new Produto(20,"Donkey Kong Country", Produto.departamento.games, 32.0, 1.0, 4, "Old but gold.");
    }

    public Produto[] listaPorDepartamento( Produto.departamento dep) {

        int j =0;
        for (Produto produto : this.produtos)
            if (produto.getDep() == dep)
                j++;

        Produto[] temp = new Produto[j];
        j = 0;
        for (int i = 0; i < this.produtos.length; i++)
            if (this.produtos[i].getDep() == dep){
                temp[j] = this.produtos[i];
                j++;
            }

        return temp;
    }

    public String exibirTodosProdutos(){
        String sTemp = "";

        for (int i = 0; i < this.produtos.length; i++) {
            sTemp = sTemp + this.produtos[i].exibirResumo();
        }

        return sTemp;
    }

}