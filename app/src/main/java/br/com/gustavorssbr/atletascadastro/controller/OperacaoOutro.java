package br.com.gustavorssbr.atletascadastro.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.gustavorssbr.atletascadastro.model.AtletaOutro;

public class OperacaoOutro implements IOperacao<AtletaOutro>{
    private List<AtletaOutro> lista;

    public OperacaoOutro(){
        lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaOutro atletaOutro) {
        lista.add(atletaOutro);

    }

    @Override
    public List<AtletaOutro> listar() {
        return lista;
    }
}
