package br.com.gustavorssbr.atletascadastro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gustavorssbr.atletascadastro.model.AtletaJuvenil;
import br.com.gustavorssbr.atletascadastro.model.AtletaSenior;

public class OperacaoSenior implements IOperacao<AtletaSenior> {
    private List<AtletaSenior> lista;

    public OperacaoSenior() {
        lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(AtletaSenior atletaSenior) {

        lista.add(atletaSenior);

    }

    @Override
    public List<AtletaSenior> listar() {
        return lista;
    }
}
