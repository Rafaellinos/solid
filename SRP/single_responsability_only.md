# SRP The single responsibility only

- classe dever fazer apenas uma coisa
- classe deve ter apenas uma razao para ser modificada
- Quando uma classe possui muitas razões para mudar, a sua manutenção fica acoplada com varios motivos diferentes
- Assim, mantendo o sistema dificil de entender, modificar e manter

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


<p>Apesar do nome, esse principio não está relacionado com um módulo realizar apenas uma coisa e uma coisa muito bem, 
mas sim a coesão e "clientes" da classe.</p>

<p>No dicionário, coesão significa: "unidade lógica, coerência de um pensamento, de uma obra."
Em desenvolvimento de software, principalmente em classes, coesão é vista como a responsável pela separação de módolos e classes.
Fazendo analogia com o mundo real, qual o sentido de uma impressora numa pessoa? Não faz sentido, certo? A ideia é a mesma em POO, 
uma classe, deve conter propriedades relacionadas a sua existencia num sentido lógico, uma classe de Pessoa deve conter dados e talvez
validações de pessoal, mas não habilidade de imprimir formularios. Coesão pode ser aplicada para todos os níveis, módulos, classes e funções.
</p>

<p>Além da coesão, também devemos considerar um único ator responsável por determinada classe ou módulo. O ator é basicamente o usuário, stackholder ou grupo
interessado em mudanças nessa classe. Exemplo: </p>

