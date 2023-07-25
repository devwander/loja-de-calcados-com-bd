package com.upe.classes;

public class Calcado {
    private String marca;
    private String tipo;
    private String cor;
    private String tamanho;
    private int estoque;
    private boolean disponibilidade;
    private float preco;

    public Calcado(String marca, String tipo, String cor, String tamanho, int estoque, boolean status, float preco) {
        this.marca = marca;
        this.tipo = tipo;
        this.cor = cor;
        this.tamanho = tamanho;
        this.estoque = estoque;
        this.disponibilidade = status;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void detalhes() {
        System.out.println("Calcado {" + "\n" + "marca=" + marca + "\n" + "tipo=" + tipo + "\n" + "cor=" + cor + "\n" + "tamanho=" + tamanho + "\n" + "quantidade=" + estoque + "\n" + "disponibilidade=" + disponibilidade + "\n" + "preco=" + preco + '}');
    }
}
