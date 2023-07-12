package com.upe;

import com.upe.classes.Cliente;
import com.upe.classesDAO.ClienteDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;

        try {
            con = new Conexao().iniciar();
            try {
                Cliente c1 = new Cliente("Jorge", 30, "001.002.003-45", "M");
                ClienteDAO cbd1 = new ClienteDAO();

                cbd1.incluir(c1);

                cbd1.consultar(c1);

                cbd1.atualizar(c1, "001.002.003-45", "Jorge UPE", 29, "M");

                cbd1.consultar(c1);

                cbd1.deletar(c1);

                cbd1.consultar(c1);

            } catch (SQLException error) {
                System.out.println(error);
            }
        } finally {
            con.close();
        }
    }
}