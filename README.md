# Clean Code com Features do Java 8 a Java 14

##  default and static methods in Interfaces - Paula

## Functional Interfaces and Lambda Expressions
 
## Java Stream API for Bulk Data Operations on Collections

## Java Time API - Retorno da semântica com DDD .now() example, tipos, mês é enum ao invés de inteiro antes era 0-11, é imutável.

## Collection API improvements

## Factory Methods for Immutable List, Set, Map and Map.Entry - Paula

## Private methods in Interfaces - Paula

## CompletableFuture API Improvements  1.8 -

## Optional Class Improvements 1.8 

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

