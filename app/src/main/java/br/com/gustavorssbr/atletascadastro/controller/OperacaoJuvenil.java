package br.com.gustavorssbr.atletascadastro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gustavorssbr.atletascadastro.model.AtletaJuvenil;

public class OperacaoJuvenil implements IOperacao<AtletaJuvenil> {
    private List<AtletaJuvenil> lista;

    public OperacaoJuvenil() {
        // Inicialize a lista para evitar NullPointerException
        lista = new ArrayList<>();
    }


    @Override
    public void cadastrar(AtletaJuvenil atletaJuvenil) {
        lista.add(atletaJuvenil);
    }

    @Override
    public List<AtletaJuvenil> listar() {
        return lista;
    }
}
