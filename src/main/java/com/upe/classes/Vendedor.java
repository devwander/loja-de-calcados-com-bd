package com.upe.classes;

public class Vendedor extends Pessoa {
    private int numeroId;
    private int vendas;
    private String turno;
    private float salario;

    public Vendedor(String nome, int idade, String cpf, String sexo, int numeroId, String turno, float salario) {
        super(nome, idade, cpf, sexo);
        this.numeroId = numeroId;
        this.turno = turno;
        this.salario = salario;
        this.vendas = 0;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void detalhes() {
        System.out.println("Vendedor {" + "\n" + "nome=" + getNome() + "\n" + "idade=" + getIdade() + "\n" + "cpf=" + getCpf() + "\n" + "sexo=" + getSexo() + "\n" + "numeroId=" + numeroId + "\n" + "vendas=" + vendas + "\n" + "turno=" + turno  + "\n" + "salario=" + salario + '}');
    }
}
