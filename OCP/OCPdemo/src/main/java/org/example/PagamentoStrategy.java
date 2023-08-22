package org.example;

public interface PagamentoStrategy<V> {
    boolean processar(V dados);
}
