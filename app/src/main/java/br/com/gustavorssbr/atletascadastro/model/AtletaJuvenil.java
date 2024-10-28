package br.com.gustavorssbr.atletascadastro.model;

import androidx.annotation.NonNull;

public class AtletaJuvenil extends Atleta {
    private int qtdAnosPratica;

    public AtletaJuvenil(String nome, String dataNasc, String bairro, int qtdAnosPratica) {
        super(nome, dataNasc, bairro);
        this.qtdAnosPratica = qtdAnosPratica;
    }

    public int getQtdAnosPratica() {
        return qtdAnosPratica;
    }

    public void setQtdAnosPratica(int qtdAnosPratica) {
        this.qtdAnosPratica = qtdAnosPratica;
    }

    @Override
    @NonNull
    public String toString() {
        return super.toString() +
                "qtdAnosPratica=" + qtdAnosPratica +
                '}';
    }
}
