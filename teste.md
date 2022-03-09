# Teste de software

## O que é?
Testes de software fazem parte do fluxo de desenvolvimento de software e tem como objetivo, além de fornecer maior qualidade do software, assegurar que o sistema cumpre o objetivo para qual foi designado de forma eficiente e eficaz.
O objetivo do teste é prever erros e falhas que possam ocorrer em tempo de execução.
Os testes de software ainda são pontos a ser discutidos em todo um projeto, pois exigem recursos de tempo e infra estrutura, porém trazem um ponto bastante positivo em relação à qualidade.

## Processo de teste de software

O processo de teste segue o processo de desenvolvimento de software. 

Um primeiro momento é a **análise dos requisitos**, ondem são identificados quais os tipos de teste deverão ser executados no projeto, baseando-se nas necessidades dos interessados no projeto, bem como a prioridade destes. Nesta etapa também é discutida a necessidade de automatização de testes. Posteriormente um analista de qualidade tem como objetivo realizar um **plano de teste** informando quais são as ferramentas, bem como os recursos necessários para a execução de testes em todo o projeto. A partir da definição das ferramentas, testes que compreendem o projeto e os recursos necessários as próximas etapas do ciclo de vida seguem um modelo iterativo, onde cada iteração corresponde a uma etapa do desenvolvimento dos testes.

A primeira fase do fluxo iterativo corresponde ao **planejamento dos testes**, que define o que será testado, ou seja, baseando-se no que será desenvolvido, são elaborados cenários de testes, bem como os responsáveis pela execução do mesmo. 

A partir dos cenários elaborados, a próxima fase consiste na **implementação dos testes**, bem como a integração destes com os já executados em iterações anteriores.

Com as implementações dos testes realizadas, são **coletadas informações** e em caso de erros identificados no desenvolvimeto, são elaborados planos e ações para as correções do mesmos.

## Profissionais envolvidos
Os analistas de teste são responsáveis por planejar e coletar os resultados dos testes elaborados em cada iteração. É responsabilidade deste profissional.
Os Testadores são os profissionais responsáveis pela implementação e execução dos testes de software. Em alguns tipos de testes este papel é executado pelos próprios desenvolvedores.
Existem ainda os gerentes de teste que tem como objetivo provisionar recursos necessários e gerenciar o fluxo de desenvolvimento dos testes. Em equipe consideradas auto gerenciáveis este papel é executado por todos os integrantes da equipe.
> **OBS:** Dentro de uma equipe de software um profissional pode executar mais de um papel dentro do fluxo de desenvolvimento, desta forma, um analista de testes também pode ser o mesmo profissional que realiza a implementação do mesmo.


# Tipos de teste de software


## Teste unitário
Os testes unitários têm por objetivo validar pequenas partes do software com base em suas entradas possíveis e saídas esperadas. As unidades usadas nesse tipo de teste são as menores partes testáveis de um sistema, normalmente métodos ou funções, que recebem argumentos e retornam um determinado valor ou efetuam alguma ação cujo resultado pode ser analisado. Neste teste também são avaliados os fluxos de dados dentro destas parte de código avaliando se a troca de mensagens correspondem ao esperado.
> **Exemplo:** Testar um método especifico de uma classe e validando o código contido neste. 

## Teste funcionais
Teste funcionais, também chamados de teste caixa preta, consistem em testes de ações de uso real do sistema, tendo como objetivo validar as saídas esperadas a partir de entradas no sistema. Este tipo de teste avalia uma funcionalidade como um todo, não se preocupando com a forma do código desenvolvido.

> **Exemplo:** Testar uma funcionalidade de um sistema web se a autenticação esta funcionando.

## Teste de integração
Os testes de integração tem como objetivo validar todo o fluxo de mensagens de uma determinada funcionalidade, e como eles interagem. Este teste tem como intuíto avaliar o agrupameno dos módulos combinados para uma determinada funcionalidade.
> **Exemplo:** avaliar um fluxo do sistema para inserção de um usuário, desde a entrada dos dados até a inserção destes dados no banco de dados.

![](https://miro.medium.com/max/960/1*peBPc8OfE1HrqvHh6BxdOQ.gif)

## Teste aceitação
Tem como objetivo avaliar se o que foi desenvolvido corresponde ao que foi requisitado, e portanto, pode ser entregue, ou disponibilizado em ambiente de produção.

## Teste de regressão
Ao desenvolver uma determinada funcionalidade, existe a possibilidade de corromper o que já foi desenvolvido e entregue em outras iterações. Para isto, este teste tem como objetivo avaliar o conteúdo anteriormente entregue na iteração.

## Teste de carga
Têm por objetivo submeter o software a situações intensas de uso e avaliar seu comportamento.

## Teste de segurança
Tem como objetivo realizar testes em implementações de segurança estipuladas para o sistema.

## Teste automatizado
Alguns destes testes podem ser realizados de forma automática, ou seja, depois de configurados os mesmos podem ser executados automaticamente, através de ferramentas, e auxiliar o processo de teste.

A automação desse processo visa reduzir o tempo gasto nessa etapa, bem como reduzir a probabilidade de falha humana.

## Conclusão
Existem diversos tipos de testes a serem adicionados junto à um processo de desenvolvimento de sistemas, a utilização de quais testes irão compor um produto, dependem dos recursos disponibilizados, bem como do que é requisitado pelo próprio sistema. Os testes de software são bastante importantes para o desenvolvimento, pois eles trazem uma significativa garantia de qualidade ao produto desenvolvido.

# Piramide de teste

A pirâmide de testes é uma forma gráfica de demonstrar de forma simples os tipos de testes, seus níveis, velocidade de implementação e complexidade dos testes realizados.


![Piramide de teste](https://miro.medium.com/max/1036/1*S0yR438zKtJtEEBldSviFA.png)


# Teste de Unidade e o Padrão Organizar, Agir e Afirmar (AAA)

O padrão AAA (Arrange-Act-Assert) tornou-se quase um padrão em todo o setor. Ele sugere que você deve dividir seu método de teste em três seções: organizar, agir e afirmar. 

Cada um deles responsável apenas pela parte em que são nomeados.
Portanto, na seção de organização, você só tem o código necessário para configurar esse teste específico. 

Aqui os objetos seriam criados, a configuração de mocks (se você estiver usando um) e potencialmente as expectativas seriam definidas. 

Depois, há o Act, que deve ser a invocação do método que está sendo testado. E no Assert você simplesmente verificaria se as expectativas foram atendidas


[Padrão AAA](https://medium.com/@pjbgf/title-testing-code-ocd-and-the-aaa-pattern-df453975ab80)

[Piramide de teste](https://medium.com/creditas-tech/a-pir%C3%A2mide-de-testes-a0faec465cc2)

[Junit5](https://junit.org/junit5/docs/current/user-guide/#overview)
