# 🧼 Clean Architecture API

Projeto Java com arquitetura limpa usando Spring Boot.

---

## 🧩 Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.3
- Maven
- Swagger (Springdoc OpenAPI)
- Lombok
- H2 (opcional para testes locais)
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
## 🚀 Como executar
Pré-requisitos
- Java 17 instalado
- Maven instalado

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
