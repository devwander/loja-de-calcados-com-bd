package com.upe.classesDAO;

import com.upe.Conexao;
import com.upe.classes.Vendedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CREATE TABLE vendedores (
//        id SERIAL PRIMARY KEY,
//        nome VARCHAR(255) NOT NULL,
//        idade INT NOT NULL,
//        cpf VARCHAR(14) NOT NULL,
//        sexo CHAR(1) NOT NULL,
//        quantidade_vendas INT DEFAULT 0,
//        salario NUMERIC(10, 2) DEFAULT 0.0
//);

public class VendedorDAO {

    public void incluir(Vendedor vendedor) throws SQLException {
        String queryConsultar = "SELECT * FROM VENDEDORES WHERE CPF = '" + vendedor.getCpf() + "'";

        String queryIncluir = "INSERT INTO VENDEDORES (nome, idade, cpf, sexo, quantidade_vendas, salario) " +
                "VALUES ('" + vendedor.getNome() + "', " + vendedor.getIdade() + ", '" + vendedor.getCpf() + "', '" +
                vendedor.getSexo() + "', " + vendedor.getVendas() + ", " + vendedor.getSalario() + ")";

        System.out.println(queryIncluir);

        Connection con = null;

        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                System.out.println("--------------------------------------");
                System.out.println("O vendedor já está cadastrado no banco de dados!");
                System.out.println("--------------------------------------");
            } else {
                con.createStatement().execute(queryIncluir);
                System.out.println("--------------------------------------");
                System.out.println("Vendedor cadastrado com sucesso!");
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
        String queryConsultar = "SELECT * FROM VENDEDORES WHERE CPF = '" + cpf + "'";

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
                System.out.println(("quantidade vendas: " + result.getInt("QUANTIDADE_VENDAS") + ","));
                System.out.println(("salário: " + result.getFloat("SALARIO")));
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Vendedor não encontrado!");
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

    public void atualizar(Vendedor vendedor) throws SQLException {
        String queryConsultar = "SELECT * FROM VENDEDORES WHERE CPF = '" + vendedor.getCpf() + "'";

        String queryAtualizar = "UPDATE VENDEDORES SET NOME = '" + vendedor.getNome() +
                "', IDADE = " + vendedor.getIdade() + ", SEXO = '" + vendedor.getSexo() +
                "', CPF = '" + vendedor.getCpf() + "' , SALARIO = " + vendedor.getSalario() +
                " WHERE CPF = '" + vendedor.getCpf() + "'";

        System.out.println(queryAtualizar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().executeUpdate(queryAtualizar);
                System.out.println("--------------------------------------");
                System.out.println("Vendedor atualizado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Vendedor não encontrado!");
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
        String queryConsultar = "SELECT * FROM VENDEDORES WHERE CPF = '" + cpf + "'";

        String queryDeletar = "DELETE FROM VENDEDORES WHERE CPF = '" + cpf + "'";

        System.out.println(queryDeletar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            ResultSet rs = con.createStatement().executeQuery(queryConsultar);

            if (rs.next()) {
                con.createStatement().execute(queryDeletar);
                System.out.println("--------------------------------------");
                System.out.println("Vendedor apagado com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Vendedor não encontrado!");
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
