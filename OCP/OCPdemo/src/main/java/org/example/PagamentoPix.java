package org.example;

import org.example.model.DadosPix;

public class PagamentoPix implements PagamentoStrategy<DadosPix> {
    @Override
    public boolean processar(DadosPix dados) {
        return false;
    }
}
