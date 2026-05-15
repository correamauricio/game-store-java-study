# Game Store Management System 🎮

Este projeto é um sistema de gerenciamento de loja de jogos desenvolvido em **Java 21**, focado na aplicação de padrões de arquitetura robustos e práticas modernas de desenvolvimento back-end.

O objetivo principal deste repositório é demonstrar competências técnicas em **Arquitetura de Software (MVC)**, **Encapsulamento**, **Persistência de Dados** e **Conteinerização**.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Gerenciador de Dependências:** Gradle
- **Banco de Dados:** MySQL 8.0
- **Infraestrutura:** Docker & Docker Compose
- **JDBC:** MySQL Connector/J

---

## 🏛️ Arquitetura e Design Patterns

O projeto segue uma estrutura rigorosa para garantir a separação de responsabilidades e facilitar a manutenção:

### 1. MVC (Model-View-Controller)
- **Model:** Representa a lógica de negócios e o estado dos dados.
- **View:** Interface de linha de comando (CLI) para interação com o usuário.
- **Controller:** Age como intermediário, processando as entradas da View e chamando os serviços necessários.

### 2. Camada de Serviço (Service Layer)
Implementa as regras de negócio de forma isolada, garantindo que o Controller não manipule diretamente a persistência.

### 3. DAO (Data Access Object)
Centraliza toda a lógica de persistência SQL. Utiliza JDBC puro para demonstrar domínio sobre consultas, transações e gerenciamento de conexões.

### 4. DTO (Data Transfer Objects)
Utilização de objetos dedicados para transferência de dados entre as camadas (`RequestDTO` para entrada e `ResponseDTO` para saída), evitando a exposição direta das entidades de banco de dados para a View.

---

## 🐳 Docker & Banco de Dados

A infraestrutura do banco de dados é totalmente automatizada via Docker. O arquivo `docker-compose.yml` configura um container MySQL 8.0 que:
- Inicializa automaticamente o esquema do banco através do script `init.sql`.
- Configura usuários e permissões de forma isolada.
- Garante a persistência de dados através de volumes Docker.

---

## 📂 Estrutura do Projeto

```text
src/main/java/com/mauricio/gamestore/
├── controller/     # Orquestração do fluxo de dados
├── model/
│   ├── dao/        # Persistência de dados (SQL)
│   ├── dto/        # Objetos de transferência (Request/Response)
│   ├── entity/     # Classes de domínio
│   └── service/    # Regras de negócio
├── util/           # Utilitários (Conexão DB)
├── view/           # Interface de Usuário (CLI)
└── Main.java       # Ponto de entrada da aplicação
```

---

## 🛠️ Como Executar

### Pré-requisitos
- Docker e Docker Compose instalados.
- JDK 21 instalado (opcional, se rodar via Docker).

### Passo a Passo

1. **Subir o Banco de Dados:**
   ```bash
   docker-compose up -d
   ```

2. **Compilar e Rodar a Aplicação:**
   ```bash
   ./gradlew run
   ```

---

## 🧠 Conceitos Aplicados

- **POO Avançada:** Herança, polimorfismo e interfaces.
- **Tratamento de Exceções:** Gestão robusta de erros de banco de dados e lógica.
- **Clean Code:** Nomenclatura semântica e métodos de responsabilidade única.
- **SQL:** Consultas complexas, Joins e manipulação de DDL/DML.

---


> Desenvolvido por **Mauricio Correa**  
> [LinkedIn](https://www.linkedin.com/in/correa-mauricio/)
