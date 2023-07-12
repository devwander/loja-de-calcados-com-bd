package com.upe.classes;

import java.util.ArrayList;

public class Compra implements Venda {
    private Vendedor vendedor;
    private Cliente cliente;
    private ArrayList<Calcado> carrinho;
    private String status;

    private float total;

    public Compra(Vendedor vendedor, Cliente cliente) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.carrinho = new ArrayList<>();
        this.status = "Em aberto";
        this.total = 0.0f;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Calcado> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Calcado> carrinho) {
        this.carrinho = carrinho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void adicionarCalcado(Calcado cal) {
        if (this.status == "Em aberto") {
            if (cal.getQuantidade() > 0) {
                System.out.println("Calcado adicionado com sucesso!");
                this.total = this.total + cal.getPreco();
                cal.setQuantidade(cal.getQuantidade() - 1);
                this.carrinho.add(cal);
            } else {
                System.out.println("Não há estoque deste calcado!");
            }
        } else {
            System.out.println("Não é possível alterar uma compra que já foi concluída ou cancelada!");
        }
    }

    @Override
    public void removerCalcado(Calcado cal) {
        if (this.status == "Em aberto") {
            System.out.println("Calcado removido com sucesso!");
            this.total = this.total - cal.getPreco();
            cal.setQuantidade(cal.getQuantidade() + 1);
            this.carrinho.remove(cal);
        } else {
            System.out.println("Não é possível alterar uma compra que já foi concluída ou cancelada!");
        }
    }

    @Override
    public void limparCarrinho() {
        if (this.status == "Em aberto") {
            this.carrinho.clear();
            this.total = 0;
        } else {
            System.out.println("Não é possível alterar uma compra que já foi concluída ou cancelada!");
        }
    }

    @Override
    public void concluirVenda() {
        this.status = "Concluída";
        this.cliente.setTotCompras(this.cliente.getTotCompras() + 1);
        this.cliente.setTotalGasto(this.cliente.getTotalGasto() + this.total);

        this.vendedor.setVendas(this.vendedor.getVendas() + 1);
        System.out.println("A compra foi concluída!");

    }

    @Override
    public void cancelarVenda() {
        this.status = "Cancelada";
        System.out.println("A compra foi cancelada!");
    }

    @Override
    public void detalhes() {
        System.out.println("Compra {");

        for (int i = 0; i < this.carrinho.size(); i++) {
            this.carrinho.get(i).detalhes();
        }
        System.out.println("total=" + total);
        System.out.println("}");
    }
}
