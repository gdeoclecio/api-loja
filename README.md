# API Loja Copa 2026

API REST desenvolvida para o projeto Loja Copa 2026 da Residência TIC Serratec.

## Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Security
* JWT
* Maven
* MySQL
* JPA / Hibernate

## Funcionalidades

* Cadastro de usuários
* Autenticação com JWT
* Cadastro de produtos
* Listagem de produtos
* Edição de produtos
* Exclusão de produtos

## Como Executar

### 1. Clonar o repositório


### 2. Entrar na pasta

cd api-loja

### 3. Configurar banco de dados

Ajustar as configurações do banco no arquivo:

application.properties

### 4. Executar a aplicação

Pela IDE ou:

mvn spring-boot:run

A API será iniciada em:

http://localhost:8080

## Cadastro de Usuário

Antes de utilizar o aplicativo mobile, é necessário cadastrar um usuário.

Endpoint:

POST /auth/register

Exemplo:

{
"username": "[admin@gmail.com](mailto:admin@gmail.com)",
"password": "123456"
}

## Aplicativo Mobile

O aplicativo mobile que consome esta API está disponível em:

https://github.com/gdeoclecio/loja-mobile.git
