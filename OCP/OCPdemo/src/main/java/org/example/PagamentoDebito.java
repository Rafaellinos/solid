package org.example;

import org.example.model.DadosDebito;

public class PagamentoDebito implements PagamentoStrategy<DadosDebito> {

    @Override
    public boolean processar(DadosDebito dados) {
        return false;
    }
}
