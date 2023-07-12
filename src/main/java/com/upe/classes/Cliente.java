package com.upe.classes;

public class Cliente extends Pessoa {

    private int totCompras;
    private float totalGasto;

    public Cliente(String nome, int idade, String cpf, String sexo) {
        super(nome, idade, cpf, sexo);
        this.totCompras = 0;
        this.totalGasto = 0;
    }

    public int getTotCompras() {
        return totCompras;
    }

    public void setTotCompras(int totCompras) {
        this.totCompras = totCompras;
    }

    public float getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(float totalGasto) {
        this.totalGasto = totalGasto;
    }

    public void detalhes() {
        System.out.println("Cliente {" + "\n" + "nome=" + getNome() + "\n" + "idade=" + getIdade() + "\n" + "cpf=" + getCpf() + "\n" + "sexo=" + getSexo() + "\n" + "totCompras=" + totCompras + "\n" + "totalGasto=" + totalGasto + '}');
    }
}
