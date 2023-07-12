package com.upe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static void main(String[] args) {

    }

    public Connection iniciar()  throws ClassNotFoundException {
        Connection conexao = null;

        String url = "jdbc:postgresql://localhost/loja-calcados";
        String user = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar acessa o banco.");
        }
        return conexao;
    }
}
