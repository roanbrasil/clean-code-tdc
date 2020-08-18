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
 
## Java Stream API for Bulk Data Operations on Collections

## Java Time API - Retorno da semântica com DDD .now() example, tipos, mês é enum ao invés de inteiro antes era 0-11, é imutável.

## Collection API improvements

## Factory Methods for Immutable List, Set, Map and Map.Entry - Paula
###Link: https://openjdk.java.net/jeps/269
Esta feature foi motiva para evitar a verbosidade e complexidade para a criação de pequenas coleções não modificáveis.


## Private methods in Interfaces - JEP 213
###Link: https://openjdk.java.net/jeps/213
Este método deve possui implementação, não deve ser herdado.
Com as melhorias que surgiram no Java 8 para o uso de interface permitiu implementação em interfaces.
Em alguns casos de implementações auxiliares não devem ser acessíveis para clientes dequela interface.

Item do Clean Code que converge com esta feature:
Capítulo 3 - Funções


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

Item do Clean Code que converge com esta feature:
Capitulo 2 - Nomes significativos 

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

