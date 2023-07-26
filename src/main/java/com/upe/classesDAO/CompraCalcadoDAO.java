package com.upe.classesDAO;

import com.upe.Conexao;
import com.upe.classes.Calcado;
import com.upe.classes.Cliente;
import com.upe.classes.Compra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CREATE TABLE compra_calcados (
//        compra_id INT NOT NULL,
//        calcado_id INT NOT NULL,
//        CONSTRAINT pk_CC primary key(compra_id, calcado_id)
//        FOREIGN KEY (compra_id) REFERENCES compras (id),
//        FOREIGN KEY (calcado_id) REFERENCES calcados (id)
//);

public class CompraCalcadoDAO {
    public void incluirItem(int compra_id, int calcado_id) throws SQLException {

        String queryConsultarCalcado = "SELECT * FROM CALCADOS WHERE ID = '" + calcado_id + "'";

        String queryIncluir = "INSERT INTO COMPRA_CALCADOS (compra_id, calcado_id) " +
                "VALUES (" + compra_id + ", " + calcado_id + ")";

        System.out.println(queryIncluir);

        Connection con = null;

        try {
            con = new Conexao().iniciar();

            ResultSet rsCalcado = con.createStatement().executeQuery(queryConsultarCalcado);

            if (rsCalcado.next()) {
                con.createStatement().execute(queryIncluir);

                System.out.println("--------------------------------------");
                System.out.println("Item adicionado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                con.createStatement().execute(queryIncluir);
                System.out.println("--------------------------------------");
                System.out.println("O calçado não existe!");
                System.out.println("--------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public void deletarItem(int compra_id, int calcado_id) throws SQLException {
        String queryConsultar = "SELECT * FROM COMPRA_CALCADOS WHERE COMPRA_ID = " + compra_id + " AND CALCADO_ID = " + calcado_id;

        String queryDeletar = "DELETE FROM COMPRA_CALCADOS WHERE COMPRA_ID = " + compra_id + " AND CALCADO_ID = " + calcado_id;

        System.out.println(queryDeletar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().execute(queryDeletar);
                System.out.println("--------------------------------------");
                System.out.println("Item removido com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Item não encontrado!");
                System.out.println("--------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }
}
