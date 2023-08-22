package org.example;

public class PagamentoContext<V> {
    private final PagamentoStrategy<V> strategy;

    public PagamentoContext(PagamentoStrategy<V> strategy) {
        this.strategy = strategy;
    }

    public boolean processarPagamento(V dadoPagamento) {
        return strategy.processar(dadoPagamento);
    }
}
