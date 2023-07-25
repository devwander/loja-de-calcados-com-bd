package com.upe.classes;

public class Vendedor extends Pessoa {
    private int vendas;
    private float salario;

    public Vendedor(String nome, int idade, String cpf, String sexo, float salario) {
        super(nome, idade, cpf, sexo);
        this.salario = salario;
        this.vendas = 0;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void detalhes() {
        System.out.println("Vendedor {" + "\n" + "nome=" + getNome() + "\n" + "idade=" + getIdade() + "\n" + "cpf=" + getCpf() + "\n" + "sexo=" + getSexo() + "\n" + "vendas=" + vendas + "\n" + "salario=" + salario + '}');
    }
}
