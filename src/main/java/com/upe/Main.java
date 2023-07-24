package com.upe;

import com.upe.classes.Cliente;
import com.upe.classesDAO.ClienteDAO;

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
            System.out.println("5 - Encerrar programa.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Entrando no menu de clientes...");
                    ClienteDAO clientManager = new ClienteDAO();
                    menuClintes(clientManager);
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
            System.out.println("5 - Encerrar programa.");

            select = scanner.nextInt();

            switch (select) {
                case 1:
                    clientManager.incluir(captaDados());
                    break;
                case 2:
                    clientManager.consultar(captaCPF());
                    break;
                case 3:
                    clientManager.atualizar(captaDados());
                    break;
                case 4:
                    clientManager.deletar(captaCPF());
                    break;
                case 5:
                    break;
            }
        }
    }

    public static Cliente captaDados() {
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
}