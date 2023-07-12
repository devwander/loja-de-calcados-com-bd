package com.upe.classes;

public class Calcado {
    private int calcadoId;
    private String marca;
    private String tipo;
    private String cor;
    private String tamanho;
    private int quantidade;
    private boolean status;
    private float preco;

    public Calcado(int calcadoId, String marca, String tipo, String cor, String tamanho, int quantidade, boolean status, float preco) {
        this.calcadoId = calcadoId;
        this.marca = marca;
        this.tipo = tipo;
        this.cor = cor;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.status = status;
        this.preco = preco;
    }

    public int getCalcadoId() {
        return calcadoId;
    }

    public void setCalcadoId(int calcadoId) {
        this.calcadoId = calcadoId;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void detalhes() {
        System.out.println("Calcado {" + "\n" + "calcadoId=" + calcadoId + "\n" + "marca=" + marca + "\n" + "tipo=" + tipo + "\n" + "cor=" + cor + "\n" + "tamanho=" + tamanho + "\n" + "quantidade=" + quantidade + "\n" + "status=" + status + "\n" + "preco=" + preco + '}');
    }
}
