package model;

public class Produto {
    public int id, quantidade;
    public String nome,fabricante,categoria;
    public float preco;

    public Produto(int id, int quantidade, String nome, String fabricante, String categoria, float preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return "Produto\n{" +
                "ID : " + id +
                ", Quantidade : " + quantidade +
                ", Nome : '" + nome + '\'' +
                ", Fabricante : '" + fabricante + '\'' +
                ", Categoria : '" + categoria + '\'' +
                ", Preço : " + preco +
                '}';
    }
}
