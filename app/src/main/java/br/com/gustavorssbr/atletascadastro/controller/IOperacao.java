package br.com.gustavorssbr.atletascadastro.controller;

import java.util.List;

public interface IOperacao <T> {

    void cadastrar(T t);

    List<T> listar();

}
