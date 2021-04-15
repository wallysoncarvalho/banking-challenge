# Desafio de Backend

Seu objetivo é criar uma API REST com algumas funções essenciais relacionadas ao gerenciamento de contas bancárias:

- Para abrir uma conta é necessário apenas o nome completo e CPF da pessoa, mas só é permitido uma conta por pessoa;
- Com essa conta é possível realizar transferências para outras contas e depositar;
- Não aceitamos valores negativos nas contas;
- Por questão de segurança cada transação de depósito não pode ser maior do que R$2.000;
- As transferências entre contas são gratuitas e ilimitadas;

Em relação a banco de dados, quem decide é o dev mesmo.

Por favor, não esquecer de adicionar no README as instruções de como executar o projeto.

## O que avaliamos?

- Performance
- Testes
- Manutenabilidade
- Princípios de programação
- Arquitetura de Software

<hr>

# Solução

O projeto foi desenvolvido em Java 11 utilizando as ferramentas da stack [Spring](https://spring.io/) para criação do
servidor http e tratar das operações de persistência.

Pela simplicidade do projeto foi utilizado o banco de dados "in memory" H2.

Para testes, foram utilizados o Junit 5 (Jupiter), Mockito e o `spring-boot-starter-test`, este último foi necessário
para escrever os testes da camada WEB.

## Executando a aplicação

O projeto pode ser facilmente executado utilizando o docker, mais especificamente, executando os comandos abaixo:

```
docker build --tag desafio-wallyson .

docker run --name dd-wallyson -p 8090:8090 desafio-wallyson
```

## Estrutura do projeto

O projeto foi estruturado a visar as principais ideias de _Clean Architecture_, separando os detalhes das regras de
negócio.

L **core**: Todas as regras de negócio da aplicação estão centralizadas nesta aplicação; <br>
L **persistence**: Implementação das operações de persistência definidas no pacote `ports` da aplicação core; <br>
L **spring-rest**: Implementação da API REST para manipulação das operações referents ao cliente. Também pode ser
considerado como uma entrada para a execução das regras de negócio da aplicação.<br>

A aplicação core possui uma suite de testes unitários para as regras de negócio, assim como a spring-rest para testar a
camada WEB. [Uma rotina foi configurada no Github Actions](https://github.com/wallysoncarvalho/desafio-donus/actions)
para verificar se a aplicação está sendo construidade adequadamente e se os testes estão sendo aceitos.

## Breve descrição da API REST

O arquivo `desafio-donus.postman_collection`, que se encontra na raiz do projeto, pode ser importado
no [Postman](https://www.postman.com/) para executar as operações da API REST.

### /client

- Descrição: Cria um novo cliente
- Method: POST
- Body: `{ "from": <string>, "to": <string>, "value": <string> }`

### /client/deposit

- Descrição: Deposita um valor na conta de um cliente registrado.
- Method: POST
- Body: `{ "clientId": <string>, "value": <integer> }`

### /client/transfer

- Descrição: Transfere um valor do cliente `from` para o `to`
- Method: POST
- Body: `{ "from": <string>, "to": <string>, "value": <integer> }`
