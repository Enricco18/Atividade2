package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonUsuarioDAO {
    private static SingletonUsuarioDAO instance = null;
    private Connection con;
    public static SingletonUsuarioDAO getInstance(){
        if(instance == null)
            instance = new SingletonUsuarioDAO();
        return instance;
    }

    private SingletonUsuarioDAO(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:meu_banco.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insereUsuario( Usuario adicionado){
            PreparedStatement comandoSQL;
            try {
                comandoSQL = con.prepareStatement("INSERT INTO usuarios VALUES(null, ?, ?);");
                comandoSQL.setString(1, adicionado.nome);
                comandoSQL.setString(2, adicionado.senha);
                comandoSQL.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                return true;
    }

    public Usuario getUser(String nome, String senha){
        Usuario user = null;
        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery("SELECT * FROM usuarios WHERE nome='"+nome+"' AND senha='"+senha+"';");
                user = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("senha")

            );
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery("SELECT * FROM usuarios;");
            while(rs.next()){
                Usuario user = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("senha")

                );
                usuarios.add(user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return usuarios;
    }
}
