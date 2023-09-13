package com.upe.classesDAO;

import com.upe.Conexao;
import com.upe.classes.Calcado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CREATE TABLE calcados (
//        id SERIAL PRIMARY KEY,
//        marca VARCHAR(255) NOT NULL,
//        tipo VARCHAR(55) NOT NULL,
//        tamanho VARCHAR(55) NOT NULL,
//        estoque INT NOT NULl,
//        disponibilidade boolean NOT NULL,
//        preco NUMERIC(10, 2) DEFAULT 0.0,
//        cor VARCHAR(55) NOT NULL
//);

public class CalcadoDAO {

    public void incluir(Calcado calcado) throws SQLException {

        String queryIncluir = "INSERT INTO CALCADOS (marca, tipo, tamanho, estoque, disponibilidade, preco, cor) " +
                "VALUES ('" + calcado.getMarca() + "', '" + calcado.getTipo() + "', '" + calcado.getTamanho() + "'," +
                calcado.getEstoque() + ", " + calcado.isDisponibilidade() + ", " + calcado.getPreco() + ", '"
                + calcado.getCor() + "')";

        System.out.println(queryIncluir);

        Connection con = null;

        try {
            con = new Conexao().iniciar();

            con.createStatement().execute(queryIncluir);
            System.out.println("--------------------------------------");
            System.out.println("Calçado cadastrado com sucesso!");
            System.out.println("--------------------------------------");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public void consultar(int id) throws SQLException {
        String queryConsultar = "SELECT * FROM CALCADOS WHERE ID = '" + id + "'";

        System.out.println(queryConsultar);

        Connection con = null;

        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsultar);

            if(result.next()) {
                System.out.println("--------------------------------------");
                System.out.println(("id: " + result.getInt("ID") + ","));
                System.out.println(("marca: " + result.getString("MARCA") + ","));
                System.out.println(("tipo: " + result.getString("TIPO") + ","));
                System.out.println(("tamanho: " + result.getString("TAMANHO") + ","));
                System.out.println(("estoque: " + result.getInt("ESTOQUE") + ","));
                System.out.println(("disponibilidade: " + result.getBoolean("DISPONIBILIDADE") + ","));
                System.out.println(("preço: " + result.getFloat("PRECO") + ","));
                System.out.println(("cor: " + result.getString("COR") + ","));

                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Calçado não encontrado!");
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

    public void consultarTodos() throws SQLException {
        String queryConsultar = "SELECT * FROM CALCADOS ORDER BY CALCADOS.ID";

        System.out.println(queryConsultar);

        Connection con = null;

        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsultar);

            while (result.next()) {
                System.out.println("--------------------------------------");
                System.out.println(("id: " + result.getInt("ID") + ","));
                System.out.println(("marca: " + result.getString("MARCA") + ","));
                System.out.println(("tipo: " + result.getString("TIPO") + ","));
                System.out.println(("tamanho: " + result.getString("TAMANHO") + ","));
                System.out.println(("estoque: " + result.getInt("ESTOQUE") + ","));
                System.out.println(("disponibilidade: " + result.getBoolean("DISPONIBILIDADE") + ","));
                System.out.println(("preço: " + result.getFloat("PRECO") + ","));
                System.out.println(("cor: " + result.getString("COR") + ","));
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

    public void atualizar(int id, Calcado calcado) throws SQLException {
        String queryConsultar = "SELECT * FROM CALCADOS WHERE ID = '" + id + "'";

        String queryAtualizar = "UPDATE CALCADOS SET MARCA = '" + calcado.getMarca() +
                "', TIPO = '" + calcado.getTipo() + "', TAMANHO = '" + calcado.getTamanho() +
                "', ESTOQUE = " + calcado.getEstoque() + ", DISPONIBILIDADE = " + calcado.isDisponibilidade() +
                ", PRECO = " + calcado.getPreco() + ", COR = '" + calcado.getCor() + "' "
                + " WHERE ID = '" + id + "'";

        System.out.println(queryAtualizar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().executeUpdate(queryAtualizar);
                System.out.println("--------------------------------------");
                System.out.println("Calçado atualizado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Calçado não encontrado!");
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

    public void deletar(int id) throws SQLException {
        String queryConsultar = "SELECT * FROM CALCADOS WHERE ID = '" + id + "'";

        String queryDeletar = "DELETE FROM CALCADOS WHERE ID = '" + id + "'";

        System.out.println(queryDeletar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().execute(queryDeletar);
                System.out.println("--------------------------------------");
                System.out.println("Calçado apagado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Calçado não encontrado!");
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
