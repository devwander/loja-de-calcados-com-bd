package com.upe.classesDAO;

import com.upe.Conexao;
import com.upe.classes.Compra;

import java.sql.*;

//CREATE TABLE compras (
//        id SERIAL PRIMARY KEY,
//        vendedor_id INT NOT NULL,
//        cliente_id INT NOT NULL,
//        status VARCHAR(55) NOT NULL,
//        data DATE DEFAULT NOW(),
//        total NUMERIC(10, 2) NOT NULL DEFAULT 0.0,
//        FOREIGN KEY (vendedor_id) REFERENCES vendedores (id),
//        FOREIGN KEY (cliente_id) REFERENCES clientes (id)
//);

public class CompraDAO {

    public int incluir(Compra compra) throws SQLException {

        String queryConsultarCliente = "SELECT * FROM CLIENTES WHERE ID = '" + compra.getCliente_id() + "'";

        String queryConsultarVendedor = "SELECT * FROM VENDEDORES WHERE ID = '" + compra.getVendedor_id() + "'";

        String queryIncluir = "INSERT INTO COMPRAS (vendedor_id, cliente_id, status) " +
                "VALUES (" + compra.getVendedor_id() + "," + compra.getCliente_id() + ", '" + compra.getStatus() + "'" + ")";

        System.out.println(queryIncluir);

        Connection con = null;

        long idGerado = -1;

        try {
            con = new Conexao().iniciar();

            ResultSet rsCliente = con.createStatement().executeQuery(queryConsultarCliente);

            if (rsCliente.next()) {
                System.out.println("--------------------------------------");
                System.out.println("Cliente localizado!");
                System.out.println("--------------------------------------");

                ResultSet rsVendedor = con.createStatement().executeQuery(queryConsultarVendedor);
                if (rsVendedor.next()) {
                    System.out.println("--------------------------------------");
                    System.out.println("Vendedor localizado!");
                    System.out.println("--------------------------------------");

                    PreparedStatement statement = con.prepareStatement(queryIncluir, Statement.RETURN_GENERATED_KEYS);
                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        ResultSet generatedKeys = statement.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            idGerado = generatedKeys.getLong(1);
                            System.out.println("--------------------------------------");
                            System.out.println("Compra cadastrada com sucesso! ID gerado: " + idGerado);
                            System.out.println("--------------------------------------");
                        }
                    }
                } else {
                    System.out.println("--------------------------------------");
                    System.out.println("ERRO: Vendedor não localizado!");
                    System.out.println("--------------------------------------");
                }
            } else {
                System.out.println("--------------------------------------");
                System.out.println("ERRO: Cliente não localizado!");
                System.out.println("--------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
            return (int) idGerado;
        }
    }

    public void consultar(int compra_id) throws SQLException {
        String queryConsultar = "SELECT * FROM COMPRAS WHERE ID = " + compra_id + "";

        System.out.println(queryConsultar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsultar);

            if(result.next()) {
                System.out.println("--------------------------------------");
                System.out.println(("id: " + result.getInt("ID") + ","));
                System.out.println(("vendedor_id: " + result.getInt("VENDEDOR_ID") + ","));
                System.out.println(("cliente_id: " + result.getInt("CLIENTE_ID") + ","));
                System.out.println(("status: " + result.getString("STATUS") + ","));
                System.out.println(("data: " + result.getString("DATA")));
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Compra não encontrado!");
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

    public void cancelarCompra(int compra_id) throws SQLException {
        String queryConsulta = "SELECT * FROM COMPRAS WHERE ID = " + compra_id;
        String queryAtualizar = "UPDATE COMPRAS SET STATUS = 'CANCELADA' WHERE ID = " + compra_id;

        System.out.println(queryAtualizar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsulta);

            if (result.next()) {
                con.createStatement().executeUpdate(queryAtualizar);
                System.out.println("--------------------------------------");
                System.out.println("Compra - " + compra_id + " cancelada com sucesso com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Não foi possível localizar a compra!");
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

    public void concluirCompra(int compra_id) throws SQLException {
        String queryConsulta = "SELECT * FROM COMPRAS WHERE ID = " + compra_id;
        String queryAtualizar = "UPDATE COMPRAS SET STATUS = 'CONCLUIDA' WHERE ID = " + compra_id;

        System.out.println(queryAtualizar);

        Connection con = null;
        try {
            con = new Conexao().iniciar();

            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(queryConsulta);

            if (result.next()) {
                con.createStatement().executeUpdate(queryAtualizar);

                String queryValorTotal = "SELECT COMPRA_ID, SUM(CALCADOS.PRECO) AS TOTAL " +
                    "FROM COMPRA_CALCADOS INNER JOIN CALCADOS ON CALCADO_ID = CALCADOS.ID WHERE COMPRA_ID = "
                        + compra_id + "GROUP BY COMPRA_ID";

                ResultSet pegarValor = stm.executeQuery(queryValorTotal);

                if(pegarValor.next()) {
                    float valorTotal = pegarValor.getFloat("TOTAL");

                    String queryAdicionarTotal = "UPDATE COMPRAS SET TOTAL = " + valorTotal;

                    String queryCompra = "SELECT * FROM COMPRAS WHERE ID =" + compra_id;

                    ResultSet retornaIds = stm.executeQuery(queryCompra);

                    if (retornaIds.next()) {
                        int vendedorID = retornaIds.getInt("VENDEDOR_ID");
                        int clienteID = retornaIds.getInt("CLIENTE_ID");

                        String queryUpdateQV = "UPDATE VENDEDORES SET QUANTIDADE_VENDAS = QUANTIDADE_VENDAS + 1 WHERE ID = "+ vendedorID;
                        String queryUpdateTCeTG = "UPDATE CLIENTES SET TOTAL_COMPRAS = TOTAL_COMPRAS + 1," + " TOTAL_GASTO = TOTAL_GASTO + " + valorTotal + " WHERE ID = " + clienteID;

                        con.createStatement().executeUpdate(queryUpdateQV);
                        con.createStatement().executeUpdate(queryUpdateTCeTG);
                    }

                    con.createStatement().executeUpdate(queryAdicionarTotal);
                }

                System.out.println("--------------------------------------");
                System.out.println("Compra - " + compra_id + " concluída com sucesso com sucesso!");
                System.out.println("--------------------------------------");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("Não foi possível localizar a compra!");
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
