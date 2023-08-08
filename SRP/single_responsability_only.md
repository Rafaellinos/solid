# SRP The single responsibility only

- classe dever fazer apenas uma coisa
- classe deve ter apenas uma razao para ser modificada

> Coesão é o que faz tudo ter sentido em SRP, pois é o que diferencia o limiete entre
> o que é responsabilidade de uma classe ou não, se faz parte lógica daquilo


- O que é coesão?
  - No dicionário, coesão significa: unidade lógica, coerência de um pensamento, de uma obra.
  - Em software development, significa relacionar atributos de maneira lógica e separa-los em classes e funções.
  - Um bom exemplo disso seria não misturar uma classe de Calculo com impressão do calculo


> Um módulo deveria ser responsável por um e apenas um ator.

- O que é um ator?
  - Grupo que necessitam de uma mudança em determinado objeto.

- O que é um módulo?
  - Basicamente, um grupo coeso de funções e estruturas de dados

- O que ferir o SRP causaria?
  - Anti pattern GOD class

- Como identificador um problema de SRP?
  - Simples, uma classe tem metodos que atendem 3 tipos diferentes de atores.
  - ex: Classe de cotação de apolice de seguro ter o método imprimir, cotação e cobrar
