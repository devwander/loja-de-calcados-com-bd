package com.upe;

import com.upe.classes.Calcado;
import com.upe.classes.Cliente;
import com.upe.classes.Compra;
import com.upe.classes.Vendedor;
import com.upe.classesDAO.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
            menu();
    }

    public static void menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (select != 5) {
            System.out.println("\n------- Menu Loja de Calcados -------");
            System.out.println("1 - Menu de clientes.");
            System.out.println("2 - Menu de vendedores.");
            System.out.println("3 - Menu de calçados.");
            System.out.println("4 - Menu de compras.");
            System.out.println("5 - Encerrar programa.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Entrando no menu de clientes...");
                    ClienteDAO clientManager = new ClienteDAO();
                    menuClintes(clientManager);
                    break;
                case 2:
                    System.out.println("Entrando no menu de vendedores...");
                    VendedorDAO sellerManager = new VendedorDAO();
                    menuVendedores(sellerManager);
                    break;
                case 3:
                    System.out.println("Entrando no menu de calçados...");
                    CalcadoDAO shoeManager = new CalcadoDAO();
                    menuCalcados(shoeManager);
                    break;
                case 4:
                    System.out.println("Entrando no menu de compras...");
                    CompraDAO buyManager = new CompraDAO();
                    menuCompra(buyManager);
                    break;
                case 5:
                    break;
            }
        }
    }

    public static void menuClintes(ClienteDAO clientManager) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (select != 5) {
            System.out.println("\n------- Menu Loja de Calcados (Gerência de clientes) -------");
            System.out.println("1 - Cadastrar cliente.");
            System.out.println("2 - Buscar cliente.");
            System.out.println("3 - Atualizar cliente.");
            System.out.println("4 - Excluir cliente.");
            System.out.println("5 - Encerrar menu clientes.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    clientManager.incluir(captaDadosCliente());
                    break;
                case 2:
                    clientManager.consultar(captaCPF());
                    break;
                case 3:
                    clientManager.atualizar(captaDadosCliente());
                    break;
                case 4:
                    clientManager.deletar(captaCPF());
                    break;
                case 5:
                    break;
            }
        }
    }

    public static Cliente captaDadosCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os dados do cliente a seguir:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        String idadeString = scanner.nextLine();
        int idade = Integer.parseInt(idadeString);

        System.out.print("Sexo (M|F): ");
        String sexo = scanner.nextLine();

        return new Cliente(nome, idade, cpf, sexo);
    }

    public static String captaCPF() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o CPF do cliente que busca:");
        return scanner.nextLine();
    }

    public static void menuVendedores(VendedorDAO sellerManager) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (select != 5) {
            System.out.println("\n------- Menu Loja de Calcados (Gerência de vendedores) -------");
            System.out.println("1 - Cadastrar vendedor.");
            System.out.println("2 - Buscar vendedor.");
            System.out.println("3 - Atualizar vendedor.");
            System.out.println("4 - Excluir vendedor.");
            System.out.println("5 - Encerrar menu vendedores.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    sellerManager.incluir(captaDadosVendedor());
                    break;
                case 2:
                    sellerManager.consultar(captaCPF());
                    break;
                case 3:
                    sellerManager.atualizar(captaDadosVendedor());
                    break;
                case 4:
                    sellerManager.deletar(captaCPF());
                    break;
                case 5:
                    break;
            }
        }
    }

    public static Vendedor captaDadosVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os dados do cliente a seguir:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        String idadeString = scanner.nextLine();
        int idade = Integer.parseInt(idadeString);

        System.out.print("Sexo (M|F): ");
        String sexo = scanner.nextLine();

        System.out.print("Salário: ");
        String salarioString = scanner.nextLine();
        float salario = Float.parseFloat(salarioString);

        return new Vendedor(nome, idade, cpf, sexo, salario);
    }

    public static void menuCalcados(CalcadoDAO shoeManager) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (select != 6) {
            System.out.println("\n------- Menu Loja de Calcados (Gerência de calçados) -------");
            System.out.println("1 - Cadastrar calçado.");
            System.out.println("2 - Buscar calçado.");
            System.out.println("3 - Buscar todos os calçados.");
            System.out.println("4 - Atualizar calçado.");
            System.out.println("5 - Excluir calçado.");
            System.out.println("6 - Encerrar menu calçados.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    shoeManager.incluir(captaDadosCalcado());
                    break;
                case 2:
                    shoeManager.consultar(captaIdCalcado());
                    break;
                case 3:
                    shoeManager.consultarTodos();
                    break;
                case 4:
                    shoeManager.atualizar(captaIdCalcado(), captaDadosCalcado());
                    break;
                case 5:
                    shoeManager.deletar(captaIdCalcado());
                case 6:
                    break;
            }
        }
    }

    public static Calcado captaDadosCalcado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os dados do calçado a seguir:");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Tamanho: ");
        String tamanho = scanner.nextLine();

        System.out.print("Estoque: ");
        String estoqueString = scanner.nextLine();
        int estoque = Integer.parseInt(estoqueString);

        System.out.print("Disponibilidade: ");
        String disponibilidadeString = scanner.nextLine();
        boolean disponibilidade = Boolean.parseBoolean(disponibilidadeString);

        System.out.print("Preço: ");
        String precoString = scanner.nextLine();
        float preco = Float.parseFloat(precoString);

        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        return new Calcado(marca, tipo, cor, tamanho, estoque, disponibilidade, preco);
    }

    public static int captaIdCalcado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o id do calçado: ");

        String idString = scanner.nextLine();
        return Integer.parseInt(idString);
    }

    public static int captaIdCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o id da Compra: ");

        String idString = scanner.nextLine();
        return Integer.parseInt(idString);
    }

    public static void menuCompra(CompraDAO buyManager) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (select != 5) {
            System.out.println("\n------- Menu Loja de Calcados (Gerência de compras) -------");
            System.out.println("1 - Criar nova compra.");
            System.out.println("2 - Buscar compra.");
            System.out.println("3 - Cancelar compra.");
            System.out.println("4 - Concluir compra.");
            System.out.println("5 - Encerrar menu compras.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    CompraCalcadoDAO compraCalcadoManager = new CompraCalcadoDAO();
                    int compra_id = buyManager.incluir(captaDadosCompra());
                    adiministrarCompra(compra_id, compraCalcadoManager);
                    break;
                case 2:
                    buyManager.consultar(captaIdCompra());
                    break;
                case 3:
                    buyManager.cancelarCompra(captaIdCompra());
                    break;
                case 4:
                    buyManager.concluirCompra(captaIdCompra());
                    break;
                case 5:
                    break;
            }
        }
    }

    public static Compra captaDadosCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os dados a seguir:");

        System.out.print("Id do vendedor: ");
        String idVendedorString = scanner.nextLine();
        int vendedor_id = Integer.parseInt(idVendedorString);

        System.out.print("Id do cliente: ");
        String idClienteString = scanner.nextLine();
        int cliente_id = Integer.parseInt(idClienteString);

        return new Compra(vendedor_id, cliente_id);
    }

    public static void adiministrarCompra(int compra_id, CompraCalcadoDAO compraCalcadoManager) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (select != 3) {
            System.out.println("\n------- Menu Gerência de compras -------");
            System.out.println("1 - Adicionar item.");
            System.out.println("2 - Remover item.");
            System.out.println("3 - Sair.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    captaDadosItem(compra_id, compraCalcadoManager, "incluir");
                    break;
                case 2:
                    captaDadosItem(compra_id, compraCalcadoManager, "deletar");
                    break;
                case 3:
                    break;
            }
        }
    }

    public static void captaDadosItem(int compra_id, CompraCalcadoDAO compraCalcadoManager, String tipo) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os dados do item:");

        System.out.print("Id do calcado: ");
        String idCalcadoString = scanner.nextLine();
        int calcado_id = Integer.parseInt(idCalcadoString);

        if (tipo == "incluir") {
            compraCalcadoManager.incluirItem(compra_id, calcado_id);
        } else {
            compraCalcadoManager.deletarItem(compra_id, calcado_id);
        }
    }
}