package com.upe.classesDAO;

import com.upe.Conexao;
import com.upe.classes.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CREATE TABLE clientes (
//        nome VARCHAR(255),
//        idade INT,
//        cpf VARCHAR(14),
//        sexo CHAR(1),
//        totCompras INT,
//        totalGasto NUMERIC(10, 2)
//        );

public class ClienteDAO {

    public void incluir(Cliente cliente) throws SQLException {
        String queryIncluir = "INSERT INTO CLIENTES VALUES ('" + cliente.getNome() + "'," +
                + cliente.getIdade() + ", '"
                + cliente.getCpf() + "', '"
                + cliente.getSexo() + "', "
                + cliente.getTotCompras() + ", "
                + cliente.getTotalGasto() + ")";
        System.out.println(queryIncluir);

        Connection con = null;
        try {
            con = new Conexao().iniciar();
            con.createStatement().execute(queryIncluir);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public void consultar(Cliente cliente) throws SQLException {
        String queryConsultar = "SELECT * FROM CLIENTES WHERE CPF = '" + cliente.getCpf() + "'";
        System.out.println(queryConsultar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsultar);

            if(result.next()) {
                System.out.println((result.getString("NOME")));
                System.out.println((result.getInt("IDADE")));
                System.out.println((result.getString("CPF")));
                System.out.println((result.getString("SEXO")));
                System.out.println((result.getInt("TOT_COMPRAS")));
                System.out.println((result.getFloat("TOTAL_GASTO")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public void atualizar(Cliente cliente, String cpf, String nome, int idade, String sexo) throws SQLException {
        String queryAtualizar = "UPDATE CLIENTES SET NOME = '" + nome +
                "', IDADE = '" + idade + "', SEXO = '" + sexo +
                "', CPF = '" + cpf + "' WHERE CPF = '" + cliente.getCpf() + "'";
        System.out.println(queryAtualizar);

        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setIdade(idade);
        cliente.setSexo(sexo);

        Connection con = null;
        try {
            con = new Conexao().iniciar();
            con.createStatement().executeUpdate(queryAtualizar);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public void deletar(Cliente cliente) throws SQLException {
        String queryDeletar = "DELETE FROM CLIENTES WHERE CPF = '" + cliente.getCpf() + "'";
        System.out.println(queryDeletar);

        cliente = null;

        Connection con = null;
        try {
            con = new Conexao().iniciar();
            con.createStatement().execute(queryDeletar);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }
}
