# Clean Code com Features do Java 8 a Java 14

##  default and static methods in Interfaces - Paula
###Link : https://openjdk.java.net/jeps/126
Métodos default possuem implementação dentro de uma interface, são implicitamente públicos como qualquer outro método dentro de uma interface.
Este método será herdado pelas classes que implementam a interface.
Possui limitações como não poder acessar atributos de instância, visto que estão em uma interface.
Diferentemente dos demais métodos que são abstratos e tem sua implementação na classe, esse tipo de método tem a implementação na interface, evitando quebra ou implementações diferentes. 
Este recurso surgiu para evitar quebra de implementação em casos onde um comportamento deve ser adicionado em comum por todas as classes que implementam uma interface.
Tem um aumento no acoplamento, porém, esse recurso possui muitas limitações que mitigam uso mais nocivos.
Já métodos estáticos em interface tem como objetivo permitir aumentar o grau de coesão do design, juntando comportamentos relacionados em um único lugar, sem ter que criar um objetos, possibilitando implementação de utilitários por exemplo.
É possível realizar o mesmo com classes abstratas, porém ambos ainda são diferentes, classes abstratas possuem construtores, permitem ser relacionadas a um estado.
Devemos apenas nos atentar com conflitos que podem ser gerados através de multiplas interfaces implementadas, em caso delas possuirem default methods com especificações semelhantes.


Item do Clean Code que converge com esta feature:
Capítulo 17 : Cheiros e Heurísticas - G5: Duplicação, G13: Acoplamento Artificial

## Functional Interfaces and Lambda Expressions
Functional Interfaces ou somente interfaces funcionais, são interfaces que possuem apenas um único método abstrato.
Se tiver a necessidade de ter outro método, ele não deve ser abstrato afim de manter a sua caraterística como interface funcional.
A anotação @FunctionalInterface não é obrigatório, apenas é obrigatório manter a característica de uma interface funcional.
Para isso, veremos na sessão anterior o default e static methods em interfaces. 
Alguns exemplos de Interfaces Funcionais são Function, Supplier, Consumer, Predicate, Callable, Runnable e etc.
Já Lambdas Expressions representam a instância de uma interface funcional.

###Referências
https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

##  default and static methods in Interfaces - Paula
 
## Java Stream API for Bulk Data Operations on Collections

## Java Time API - JEP 150 / JSR 310
###Link : https://openjdk.java.net/jeps/150
###Released Version: 8
Antigamente, trabalhar com Datas em java era uma tarefa árdua. Muitas vezes precisávamos importar bibliotecas externas para facilitar a nossa vida.
Se voltarmos antes do Java 8, podemos nos recordar de que a parte de biblioteca era composto de 3 classes localizadas no pacote java.util : São elas, Date, Calendar e Timezone.
Com o Java 8, foi adicionado o pacote java.time e com isso surgiram algumas vantagens, conforme mencionado abaixo.
1. Facilidade de entendê-la. 
2. Flexibilidade 
    * com a chegada dessa nova API, existe a possibilidade de trabalhar com diveros tipos de data e tempo.
3. Imutabilidade e Thread-Safety 
    * Os métodos invocados nunca modificam o estado original do objeto, sempre geram uma nova cópia do mesmo ao ser retornado.
    * A biblioteca antiga, não era thread-safety, isso possibilitava a inclusão de diversos bugs quando precisava ter concorrência.
4. Método em cadeia
    * Os métodos mutáveis pode ser aninhados em cadeia permitindo qualquer manipulação de dados de forma bem simples.
    
Houve retorno da semântica com DDD, um clássico exemplo é LocalDate.now().
Antigamente, o mês não era enum, como hoje, ao invés disso, tínhamos inteiro antes era 0-11 e tínhamos que ficar parando e vendo que mês era.




## Collection API improvements

## Factory Methods for Immutable List, Set, Map and Map.Entry - Paula

## Private methods in Interfaces - Paula

## CompletableFuture API Improvements  1.8 -

## Optional Class Improvements 1.8
Antes do Optional, era necessário escrever muitas validações para validar se o código era nulo ou não, e mesmo assim ainda
esquecíamos de fazer gerando um NullPointerException em nosso código. O Optional<T> é uma classe que faz parte do pacote java.util, sendo um classe value-based.
Ela pode ter em sua instância apenas 2 estados, um deles vazio ou um instância do tipo T. Instâncias optionais são finais e imutáveis, entretanto a referencia de T pode ser mutável.

###Referências:
https://www.oracle.com/technical-resources/articles/java/java8-optional.html
https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

## Local-Variable Type Inference - JEP 286
###Link : https://openjdk.java.net/jeps/286
####Boas práticas com o uso de inferência de tipo https://openjdk.java.net/projects/amber/LVTIstyle.html
Este recurso permite que as variáveis tenham seu tipo identificado de acordo com o contexto pelo compilador.
O recurso é local no Java, ou seja, somente em escopo pequenos como variáveis em métodos.
Esta feture permite tornar o código mais conciso e legível.
O objetivo dessa feature é que o uso correto de nomes nas variáveis locais torne mais uma boa prática do que a declaração de seus tipos.
Seguindo o principio de design o uso da inferência de tipos esta apenas para detalhes de implementação.



## Records (Preview) – JEP 359 
###Link : https://openjdk.java.net/jeps/359
Records é um novo tipo do Java. Este tipo serve para modelar classes de dados.
Justificativa da criação do Records. é para muitas classes hoje em projetos Java possuem muitas classes que representam modelo de dados.
Geralmente estas classes possuem lista de atributos, construtores, métodos de acesso, equals, hashCode e toString.
Acabamos por criar código repetitivo e de baixo valor, o que pode dificultar em refatorações de código e facilitar erros.
Fora a quantidade de código que teremos para leitura e entendimento em casos de problemas enocntrados na aplicação.
Linguagens como Kotlin, Scala e C# possuem tipos com esse mesmo propósito e serviu como exemplo para a implementação desta feature no Java.
Além disso o tipo Record cria por default uma classe imutável, visto que o código compilado gera uma classe final com atributos final.
Este tipo tem suas restrições: Não permite novos atributos e construtores e não é permitido estender uma classe que seja do tipo Record.
Item do Clean Code que converge com esta feature:

Capitulo 6 - Objetos e Estrutura de Dados.
Capítulo 17 - Cheiros e Heurísticas - Subitem G5 - Duplicação

