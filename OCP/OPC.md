# OCP open close principe

<p>
Open Close Principle é a segunda letra do acronimo SOLID (O) e se resume a "aberto para extenção, fechado para modificação".
Basicamente, significa que uma vez que o módulo (package, class, method, etc) esteja em ambiente produtivo, não deveriamos
modifica-la diretamente, mas sim extende-la para adicionar novos comportamentos/features. Na orientação a objetos, utilizamos 
herança, interfaces e abstrações para respeitar o OCP.
</p>

<p>
Uma classe que é modificada frequentemente pode trazer sérios prejuízos para manutenabilidade, pois,
além de ter o risco de alterar um comportamento existente em produção (bugs), podemos ter conflitos entre mudanças (conflitos de merges).
É muito comum definir um contrato basico via interface afim de possibilitar maior flexibilidade e extensibilidade, além de se relacionar diratamente com Inversion of Control (IoC).
</p>

# OCP Nível de módulo

<p>
Um exemplo muito comum de violação do OCP em nível de classe é a criação de IFs statements para controlar um
fluxo que pode sofrer mudanças diretas ao adicionar novas features. Mesmo em códigos profissionais e entreprise,
o exemplo abaixo é comum:
</p>

```java
public class FormaPagamento {
    public boolean processarPagamento(TipoPagamentoEnum tipoPagamento, PagamentoDadosDto dados) {
        if (tipoPagamento.CREDITO.equals(tipoPagamento)) {
            // codigo para processar credito
        } else if (tipoPagamento.DEBITO.equals(tipoPagamento)) {
            // codigo para processar debito
        } else {
            throw new RuntimeException("Tipo de pagamento não localizado");
        }
    }
}
```

<p>
Acima vemos que a classe PlanoPagamento possui um if statement para cada de forma de pagamento. Imagine que uma nova feature
precisa ser adicionada a esse módulo e nesse feature, precisamos adicionar uma nova forma de pagamento: PIX. Para essa feature,
precisariamos alterar a classe que já está em produção, sendo assim uma violação ao OCP.
</p>

<p>Existem algumas maneiras de resolver esse problema, o mais comum é utilizar o Design Pattern (DP) Strategy.</p>
<p>É aconselhável sempre desenhar a solução antes de aplicá-la em código para sua validação.</p>

![strategy_diagrama](/assets/strategy_pagamento.svg)

<p>No diagrama acima, a classe FormaPagamento utiliza o PagamentoStrategy interface, nesse caso, ela não conhece os detalhes
de implamentação de cada uma, apenas chama o método processarPagamento.</p>

## Implementação em Código


```java
public interface PagamentoStrategy<V> {
    boolean processar(V dados);
}
```

```java
public class PagamentoDebito implements PagamentoStrategy<DadosDebito> {
    boolean processar(DadosDebito dados) {
        // codigo para processar debito
    }
}
```

```java
public class PagamentoCredito implements PagamentoStrategy<DadosCredito> {
    boolean processar(DadosCredito dados) {
        // codigo para processar credito
    }
}
```

```java
public class PagamentoPix implements D<DadosPix> {
    boolean processar(DadosPix dados) {
        // codigo para processar PIX
    }
}
```

<p>Vamos implementar uma classe de contexto, usualmente utilizada para encapsular o uso do strategy, sem necessidade do cliente saber da sua implementação.</p>
<p>Um contexto também pode ser útil para para adicionar steps de pre e pós-processamento comuns aos strategies, como validações, logging, etc.</p>

```java
public class PagamentoContext<V> {
    private final PagamentoStrategy<V> strategy;

    public PagamentoContext(PagamentoStrategy<V> strategy) {
        this.strategy = strategy;
    }

    public boolean processarPagamento(V dadoPagamento) {
        return strategy.processar(dadoPagamento);
    }
}
```

### Exemplo de Uso:

```java
package org.example;

import org.example.model.DadosCredito;

public class App {
    public static void main(String[] args) {
        DadosCredito dadosCredito = new DadosCredito();
        PagamentoContext<DadosCredito> creditoPagamentoContext = new PagamentoContext<>(new PagamentoCredito());
        boolean result = creditoPagamentoContext.processarPagamento(dadosCredito);
        System.out.println("resultado: " + result);
    }
}

```

<p>Também poderiamos implementar um Factory para criação dos Strategies, mas nesse caso, o Context cuidará dessa parte.</p>

TODO Fazer resumo

# OCP nível de arquitetura

<p>OCP vai além de design de classes e módulos. Quando usado em nível de arquitetura, esse principio auxilia na proteção de
politicas de alto nível (regras de negócio), pois, pensando em extensibilidade, podemos </p>


# Violar principio acionando novas funcionalidades o tempo inteiro X

# strategy pattern X

# state space explosion

> Guides them in the design of classes and modules
> OCP vai além de guiar design de classes e módulos, quando usado ao nível de arquitetura, esse principio
> axilia na proteção de políticas de alto nivel (regras de negócio) de mudanças entre camadas. Políticas de alto nivel
> possuem esse privilégio, pois, são o motivo real da existencia do software em sí, e a sua existencia deve ser
> exaltada, o restante, como banco de dados e camada de apresentação, são apenas detalhes.
> Lembre-se disso:
> Um bom arquiteto de software sabe centralizar e elevar o domínio de negócio e o problema a ser resolvido

![strategy_diagrama](/assets/strategy_pagamento.svg)