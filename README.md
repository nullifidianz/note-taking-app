# note-taking-app

A simple note-taking app that lets users upload markdown files, check grammar, save notes, and render them in HTML.

Based on https://roadmap.sh/projects/markdown-note-taking-app

## Features

- Upload markdown files as notes
- Grammar check (English) for note content
- List all notes
- Render markdown notes as HTML
- H2 in-memory database by default

## Requirements

- Java 17+
- Maven 3.8+

## How to Run

```bash
./mvnw spring-boot:run
```
or
```bash
mvn spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

## API Endpoints

- `POST /notes`  
  Upload a markdown file.  
  **Form field:** `file` (multipart)

- `GET /notes`  
  List all notes.

- `GET /notes/{id}/render`  
  Render note as HTML.

- `GET /notes/{id}/grammar`  
  Check grammar of note content.

## How to Test

To run the tests:

```bash
./mvnw test
```
or
```bash
mvn test
```