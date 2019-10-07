package model;

public class Venda {
    public int userId,quantidade;
    public String nomeProd;

    public Venda(int userId, int quantidade, String nomeProd) {
        this.userId = userId;
        this.quantidade = quantidade;
        this.nomeProd = nomeProd;
    }

    public Venda() {
    }

    @Override
    public String toString() {
        return "Venda\n{" +
                "ID : " + userId +
                ", Quantidade : " + quantidade +
                ", Nome do produto : '" + nomeProd + '\'' +
                '}';
    }
}
