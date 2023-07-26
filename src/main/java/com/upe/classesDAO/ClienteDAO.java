package com.upe.classesDAO;

import com.upe.Conexao;
import com.upe.classes.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CREATE TABLE clientes (
//        id SERIAL PRIMARY KEY,
//        nome VARCHAR(255) NOT NULL,
//        idade INT NOT NULL,
//        cpf VARCHAR(14) NOT NULL,
//        sexo CHAR(1) NOT NULL,
//        total_compras INT DEFAULT 0,
//        total_gasto NUMERIC(10, 2) DEFAULT 0.0
//);

public class ClienteDAO {

    public void incluir(Cliente cliente) throws SQLException {
        String queryConsultar = "SELECT * FROM CLIENTES WHERE CPF = '" + cliente.getCpf() + "'";

        String queryIncluir = "INSERT INTO CLIENTES (nome, idade, cpf, sexo, total_compras, total_gasto) " +
                "VALUES ('" + cliente.getNome() + "', " + cliente.getIdade() + ", '" + cliente.getCpf() + "', '" +
                cliente.getSexo() + "', " + cliente.getTotCompras() + ", " + cliente.getTotalGasto() + ")";

        System.out.println(queryIncluir);

        Connection con = null;

        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                System.out.println("--------------------------------------");
                System.out.println("O cliente já está cadastrado no banco de dados!");
                System.out.println("--------------------------------------");
            } else {
                con.createStatement().execute(queryIncluir);
                System.out.println("--------------------------------------");
                System.out.println("Cliente cadastrado com sucesso!");
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

    public void consultar(String cpf) throws SQLException {
        String queryConsultar = "SELECT * FROM CLIENTES WHERE CPF = '" + cpf + "'";

        System.out.println(queryConsultar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsultar);

            if(result.next()) {
                System.out.println("--------------------------------------");
                System.out.println(("id: " + result.getInt("ID") + ","));
                System.out.println(("nome: " + result.getString("NOME") + ","));
                System.out.println(("idade: " + result.getInt("IDADE") + ","));
                System.out.println(("cpf: " + result.getString("CPF") + ","));
                System.out.println(("sexo: " + result.getString("SEXO") + ","));
                System.out.println(("total_compras: " + result.getInt("TOTAL_COMPRAS") + ","));
                System.out.println(("total_gasto: " + result.getFloat("TOTAL_GASTO")));
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Cliente não encontrado!");
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

    public void atualizar(Cliente cliente) throws SQLException {
        String queryConsultar = "SELECT * FROM CLIENTES WHERE CPF = '" + cliente.getCpf() + "'";

        String queryAtualizar = "UPDATE CLIENTES SET NOME = '" + cliente.getNome() +
                "', IDADE = '" + cliente.getIdade() + "', SEXO = '" + cliente.getSexo() +
                "', CPF = '" + cliente.getCpf() + "' WHERE CPF = '" + cliente.getCpf() + "'";

        System.out.println(queryAtualizar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().executeUpdate(queryAtualizar);
                System.out.println("--------------------------------------");
                System.out.println("Cliente atualizado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Cliente não encontrado!");
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

    public void deletar(String cpf) throws SQLException {
        String queryConsultar = "SELECT * FROM CLIENTES WHERE CPF = '" + cpf + "'";

        String queryDeletar = "DELETE FROM CLIENTES WHERE CPF = '" + cpf + "'";

        System.out.println(queryDeletar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().execute(queryDeletar);
                System.out.println("--------------------------------------");
                System.out.println("Cliente apagado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Cliente não encontrado!");
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
