# note-taking-app

Um aplicativo simples de anotações que permite ao usuário enviar arquivos markdown, checar a gramática, salvar a nota e renderizá-la em HTML.

Baseado em https://roadmap.sh/projects/markdown-note-taking-app

## Funcionalidades

- Upload de arquivos markdown como notas
- Checagem gramatical (inglês) do conteúdo da nota
- Listagem de todas as notas
- Renderização de notas markdown em HTML
- Banco de dados H2 em memória por padrão

## Requisitos

- Java 17 ou superior
- Maven 3.8 ou superior

## Como Executar

```bash
./mvnw spring-boot:run
```
ou
```bash
mvn spring-boot:run
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

## Endpoints da API

- `POST /notes`  
  Envia um arquivo markdown.  
  **Campo do formulário:** `file` (multipart)

- `GET /notes`  
  Lista todas as notas.

- `GET /notes/{id}/render`  
  Renderiza a nota em HTML.

- `GET /notes/{id}/grammar`  
  Checa a gramática do conteúdo da nota.

## Como Testar

Para rodar os testes:

```bash
./mvnw test
```
ou
```bash
mvn test
``` 