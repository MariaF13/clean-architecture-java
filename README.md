# 🧼 Clean Architecture API

Projeto Java com arquitetura limpa usando Spring Boot.

Simula um sistema bancário com depósitos, saques, saldo e cartão de crédito com limite baseado no saldo mensal.

---

## 🧩 Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.3
- Maven
- Swagger (Springdoc OpenAPI)
- PostgreSQL (via Docker)
- Lombok
- JUnit / Mockito (para testes)

---

## 🧱 Estrutura de Pastas (Clean Architecture)

```text
src/
└── main/
    └── java/
        └── io/
            └── github/
                └── mariadev/
                    ├── core/         # Entidades e interfaces (domínio)
                    ├── usecase/      # Casos de uso (regras de aplicação)
                    ├── infra/        # Implementações técnicas (JPA, APIs)
                    └── application/  # Controllers, Configurações (REST, Swagger)

```

## 💳 Funcionalidades previstas
- Criar usuário

- Realizar depósitos e saques

- Consultar saldo

- Emitir cartão de crédito baseado no saldo mensal:

    - Se saldo final ≥ R$ 1000, limite = 10% do saldo
    - Atualização automática a cada mês

## 🚀 Como executar
Pré-requisitos
- Java 17 instalado
- Maven instalado
- Docker instalado

### 🐳 Subir banco de dados (PostgreSQL via Docker)

```bash
  docker-compose up -d
```
✅ Rodando o projeto
```bash
  mvn spring-boot:run
```
🧪 Testes
```bash
  mvn test
```

# 📖 Documentação da API (Swagger)

Após rodar o projeto, acesse:

```bash
  http://localhost:8080/swagger-ui.html
```

## 👩‍💻 Autora
Feito com 💗 por Maria Mendonça
