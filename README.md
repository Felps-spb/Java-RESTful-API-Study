# Java RESTful API 
Sistema de RESTful API simples simulando o cadastro de um banco

## Principais Tecnologias
- Java 21: versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- Spring Boot 3: nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- Spring Data JPA: utilizado para explorar, como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- OpenAPI (Swagger): Criação de documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- Railway: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
    class Account {
        +Long id
        +String number
        +String agency
        +BigDecimal balance
        +BigDecimal limit
    }
    
    class Card {
        +Long id
        +String number
        +BigDecimal limit
    }
    
    
    class Feature {
        +Long id
        +String icon
        +String description
    }
    
    class News {
        +Long id
        +String icon
        +String description
    }
   
    
    class User {
        +Long id
        +String name
    }
    User --> Account : 1
    User --> Card : 1
    User --> "*" Feature 
    User --> "*" News

```
