package br.com.gustavorssbr.atletascadastro.model;

import androidx.annotation.NonNull;

public class AtletaSenior extends Atleta {

    private boolean problemaCardiaco;

    public AtletaSenior(String nome, String dataNasc, String bairro, boolean problemaCardiaco) {
        super(nome, dataNasc, bairro);
        this.problemaCardiaco = problemaCardiaco;
    }

    public boolean isProblemaCardiaco() {
        return problemaCardiaco;
    }

    public void setProblemaCardiaco(boolean problemaCardiaco) {
        this.problemaCardiaco = problemaCardiaco;
    }

    @Override
    @NonNull
    public String toString() {
        return
                super.toString() +
                        "problemaCardiaco=" + problemaCardiaco +
                        '}';
    }
}
