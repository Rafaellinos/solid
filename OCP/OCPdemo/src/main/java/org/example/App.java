package org.example;

import org.example.model.DadosCredito;

public class App 
{
    public static void main( String[] args ) {
        DadosCredito dadosCredito = new DadosCredito();
        PagamentoContext<DadosCredito> creditoPagamentoContext = new PagamentoContext<>(new PagamentoCredito());
        boolean result = creditoPagamentoContext.processarPagamento(dadosCredito);
        System.out.println("resultado: " + result);
    }
}
