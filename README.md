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
- [Exemplos de entrada e saída](#-exemplos-de-entrada-e-saída)
- [Aprendizados](#-aprendizados)

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
│   └── 📄 import.sql                      # Configurações de conexão com o banco de dados e Hibernate
│
└── 📄 pom.xml                             # Gerenciador de dependências Maven (Spring Starter, MySQL, JPA)
```

</details>
## ⚙️ Regras de Negócio

- Nome deve possuir entre 3 e 80 caracteres.
- CPF deve ser válido.
- Data de nascimento não pode ter data futura.
- Não é permitido cadastrar clientes com CPF já existente.
- Atualizações devem respeitar as mesmas validações do cadastro.
- Nome e CPF não podem ter campos vazios
    
## 🚀 Como Executar

### Pré-requisitos
* Java 21 ou superior instalado.
* Maven, pois o projeto inclui o `mvnw`.

### Passo a passo
1. **Clonar o repositório:**
```bash
git clone https://github.com/hevertonxav/Desafio_api_crud_clientes.git
```
2. **Abrir o arquivo application-test.propertie:(opcional)**
```text
src/
└── main/
    └── resources/
        └── application-test.properties
```
Nesse arquivo tem todas as informações pra você precisa para logar no banco de dados H2.

3. **Executar a aplicação:**
```Bash
./mvnw spring-boot:run
```
4. **Testar os Endpoints:**

* A API estará disponível em ``http://localhost:8080``.
* Você pode importar os arquivos de teste no **Postman**.
* Você pode acessar o banco H2 através do endpoint ``http://localhost:8080/h2-console`` (opcional), preencha os campos com as informações que estão no arquivo aplication-test.propertie e clique em Connect.


## 💡 Decisões de Implementação

- Utilização de DTOs para evitar exposição direta das entidades.
- ClientUpdateDTO para não permitir a alteração do CPF do cliente já existente
- Separação em camadas Controller, Service e Repository.
- Uso de Bean Validation para validação de entrada.
- Tratamento centralizado de exceções.
- Banco H2 para ambiente de desenvolvimento e testes.

## 📋 Exemplos de Entrada e Saída

### Entrada

```json
{
  "name": "Maria Oliveira",
  "cpf": "64981455011",
  "income": 7500.0,
  "birthDate": "1990-01-15",
  "children": 2
}
```
### Saída

```json
{
  "id": 11,
  "name": "Maria Oliveira",
  "cpf": "64981455011",
  "income": 7500.0,
  "birthDate": "1990-01-15",
  "children": 2
}
```

### Exemplo de erro

```json
{
    "timestamp": "2026-06-08T23:54:19.676796500Z",
    "status": 409,
    "error": "Cliente com o CPF 98765432100 já existe",
    "path": "/clients"
}
```
## 📚 Aprendizados

- Criação de APIs REST com Spring Boot.
- Uso de DTOs para transferência de dados.
- Validação de dados com Bean Validation.
- Tratamento de exceções.
- Integração com banco de dados utilizando JPA/Hibernate.
