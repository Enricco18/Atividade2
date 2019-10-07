package dao;
import model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonVendaDAO {
    private static SingletonVendaDAO instance = null;
    private Connection con;
    public static SingletonVendaDAO getInstance(){
        if(instance == null)
            instance = new SingletonVendaDAO();
        return instance;
    }
    private SingletonVendaDAO(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:meu_banco.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertVenda(Venda venda){
            PreparedStatement comandoSQL;
            try {
                comandoSQL = con.prepareStatement(
                        "INSERT INTO vendas VALUES(?, ?, ?);"
                );
                comandoSQL.setInt(1, venda.userId);
                comandoSQL.setInt(3, venda.quantidade);
                comandoSQL.setString(2, venda.nomeProd);
                comandoSQL.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } catch (NullPointerException e){
                e.printStackTrace();
                return false;
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }

    public List<Venda> getAllVendas() {
        List<Venda> vendas = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery("SELECT * FROM vendas;");
            while (rs.next()) {
                Venda venda = new Venda(
                        rs.getInt("userId"),
                        rs.getInt("quantidade"),
                        rs.getString("nomeProd")

                );
                vendas.add(venda);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vendas;
    }
}
