package dao;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonProdutoDAO {
    private static SingletonProdutoDAO instance = null;
    private Connection con;
    public static SingletonProdutoDAO getInstance(){
        if(instance == null)
            instance = new SingletonProdutoDAO();
        return instance;
    }

    private SingletonProdutoDAO(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:meu_banco.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean inserirProduto(Produto produto){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = con.prepareStatement("INSERT INTO produtos VALUES(null, ?, ?,?,?,?);");
            comandoSQL.setString(1, produto.nome);
            comandoSQL.setFloat(2, produto.preco);
            comandoSQL.setInt(3, produto.quantidade);
            comandoSQL.setString(4, produto.fabricante);
            comandoSQL.setString(5, produto.categoria);
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Produto> getAllProdutosByType(String categoria) {
        List<Produto> produtos = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery(
                            "SELECT * FROM produtos WHERE categoria LIKE '%" + categoria + "%';"
                    );
            while(rs.next()){
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getInt("quantidade"),
                        rs.getString("nome"),
                        rs.getString("fabricante"),
                        rs.getString("categoria"),
                        rs.getFloat("preco")
                );
                produtos.add(produto);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return produtos;
    }
    public void updateProdutoQuantidade(Produto produto) {
        try {
            Statement comandoSql = con.createStatement();
            comandoSql.executeUpdate("UPDATE produtos SET "+
                    "quantidade=" + produto.quantidade +
                    " WHERE id=" + produto.id+";");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Produto getProdutoById(int id){
        Produto produto=null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos WHERE id="+id+";");
            while(rs.next()) {
                produto = new Produto(
                        rs.getInt("id"),
                        rs.getInt("quantidade"),
                        rs.getString("nome"),
                        rs.getString("fabricante"),
                        rs.getString("categoria"),
                        rs.getFloat("preco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<Produto> getAllProdutos() {
        List<Produto> produtos = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery("SELECT * FROM produtos;");
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getInt("quantidade"),
                        rs.getString("nome"),
                        rs.getString("fabricante"),
                        rs.getString("categoria"),
                        rs.getFloat("preco")
                );
                produtos.add(produto);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return produtos;
    }

}
