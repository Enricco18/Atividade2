package model;

public class Usuario {
    public int id;
    public String nome;
    public String senha;

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {}

    @Override
    public String toString() {
        return "Usuario\n{" +
                "ID : " + id +
                ", Nome : '" + nome +
                "'}";
    }

}
