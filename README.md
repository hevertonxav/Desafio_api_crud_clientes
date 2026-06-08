# Desafio CRUD de clientes 

![Status](https://img.shields.io/badge/Status-Concluído-success?style=flat-square)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-Database-09476B)
![REST API](https://img.shields.io/badge/REST-02569B?style=flat-square&logo=rest&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ_IDEA-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=flat-square&logo=Apache%20Maven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=Hibernate&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?logo=postman&logoColor=white)

Desafio proposto pelo curso de Spring Profesional Professor Nelio Alves - DevSuperior.

## 📇 Sumário
- [Objetivo do desafio](#-objetivo-do-desafio)
- [Ferramentas e tecnologias utilizadas](#-ferramentas-e-tecnologias-utilizadas)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Regras de negócio](#-regras-de-negócio)
- [Como executar](#-como-executar)
- [Endpoints](#-endpoints)
- [Decisões de implementação](#-decisões-de-implementação)
- [Fluxo de funcionamento](#-fluxo-de-funcionamento)
- [Exemplos de entrada e saída](#-exemplos-de-entrada-e-saída)

## 📌 Objetivo do desafio
Desenvolver uma API REST para gerenciamento de clientes, permitindo cadastro, consulta de todos os clientes, consulta de um cliente específico usando id, atualizaçao e deleção, o famoso CRUD. Além disso o programa deve retornar exceções e codigos de erro para o usuário permitindo assim saber a causa do problema e também retornar mensagens de dados inválidos pelo usuário.

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java 21
* **Framework:** Spring Boot (Spring Data JPA, Spring Web)
* **ORM:** Hibernate (Gerenciamento de persistência)
* **Banco de Dados:** H2
* **Testes de API:** Postman

## 🗂️ Estrutura do projeto
<details>
    <summary><strong>👉🏼🚨 Clique para acessar o conteúdo técnico completo</strong></summary>

      ## 🗂️ Estrutura do projeto

<details>
<summary><strong>👉🏼🚨 Clique para acessar o conteúdo técnico completo</strong></summary>

```text
├── 📁 src/main/java/com/heverton/client_management_api
│   ├── 📁 controllers                     # Endpoints REST para gerenciamento dos clientes
│   │   └── 📁 handlers                    # Tratamento global de exceções da API
│   ├── 📁 dto                             # Objetos de transferência de dados (entrada e saída)
│   ├── 📁 entities                        # Entidades JPA mapeadas para o banco de dados
│   ├── 📁 repositories                    # Interfaces JPA para acesso aos dados
│   ├── 📁 services                        # Regras de negócio da aplicação
│   │   └── 📁 exceptions                  # Exceções personalizadas da aplicação
│   └── ☕ ClientManagementApiApplication  # Classe principal que inicia o Spring Boot
│
├── 📁 src/main/resources
│   ├── 📄 application.properties          # Configurações da aplicação
│   ├── 📄 application-test.properties     # Configurações do ambiente de teste
│   └── 📄 import.sql                      # Dados iniciais para o banco
│
└── 📄 pom.xml                             # Gerenciador de dependências Maven
```

</details>
</details>
    


