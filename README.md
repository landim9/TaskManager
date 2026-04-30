# 📋 TaskManager API

API RESTful para gerenciamento de tarefas, desenvolvida com **Spring Boot 3** e **Java 21**.

## 🚀 Tecnologias

- Java 21 (com preview features)
- Spring Boot 3.4.5
- Spring Web (REST API)
- Jakarta Persistence (JPA)
- Maven
- Docker / Docker Compose

## 🏗️ Arquitetura

O projeto segue o padrão em camadas (Layered Architecture):

```
src/main/java/com/rafael/taskmanager/
├── controller/       # Endpoints REST
├── model/            # Entidades JPA
├── repository/       # Acesso ao banco de dados
└── service/          # Regras de negócio
```

## 📦 Modelo de Dados

### Task

| Campo       | Tipo   | Descrição              |
|-------------|--------|------------------------|
| `id`        | Long   | Identificador único    |
| `titulo`    | String | Título da tarefa       |
| `descricao` | String | Descrição detalhada    |
| `status`    | String | Status atual da tarefa |

## 🛣️ Endpoints

Base URL: `http://localhost:8080`

| Método   | Rota           | Descrição                     |
|----------|----------------|-------------------------------|
| `GET`    | `/tasks`       | Lista todas as tarefas        |
| `GET`    | `/tasks/{id}`  | Busca uma tarefa por ID       |
| `POST`   | `/tasks`       | Cria uma nova tarefa          |
| `PUT`    | `/tasks/{id}`  | Atualiza uma tarefa existente |
| `DELETE` | `/tasks/{id}`  | Remove uma tarefa             |

### Exemplos de Requisição

**Criar tarefa (POST /tasks)**
```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar anotações sobre REST e JPA",
  "status": "PENDENTE"
}
```

**Atualizar tarefa (PUT /tasks/1)**
```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar anotações sobre REST e JPA",
  "status": "CONCLUÍDA"
}
```

## ⚙️ Como Executar

### Com Docker (recomendado)

```bash
docker-compose up
```

### Sem Docker

**Pré-requisitos:** Java 21+, Maven

```bash
# Clone o repositório
git clone https://github.com/landim9/TaskManager.git
cd TaskManager

# Execute com Maven Wrapper
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch: `git checkout -b feature/minha-feature`
3. Commit suas mudanças: `git commit -m 'feat: adiciona minha feature'`
4. Push para a branch: `git push origin feature/minha-feature`
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT.
