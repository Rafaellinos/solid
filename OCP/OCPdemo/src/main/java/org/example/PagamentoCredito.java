package org.example;

import org.example.model.DadosCredito;

public class PagamentoCredito implements PagamentoStrategy<DadosCredito> {

    @Override
    public boolean processar(DadosCredito dados) {
        return false;
    }
}
