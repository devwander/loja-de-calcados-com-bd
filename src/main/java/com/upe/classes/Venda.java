package com.upe.classes;

public interface Venda {
    public void adicionarCalcado(Calcado cal);
    public void removerCalcado(Calcado cal);
    public void limparCarrinho();
    public void concluirVenda();
    public void cancelarVenda();
    public void detalhes();
}
