## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/AbdiDR/astrapay-spring-boot-external.git
cd astrapay-spring-boot-external
```

### 2. Build the Application
```bash
mvn clean compile
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

**Alternative**: Run using JAR
```bash
mvn clean package
java -jar target/astrapay-spring-boot-external-1.0-SNAPSHOT.jar
```

## 🌐 API Endpoints

Base URL: `http://localhost:8000/simple-notes/api/v1/notes`

### 📝 Notes API

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/api/v1/notes` | Get all notes | - | List of notes |
| `POST` | `/api/v1/notes` | Create a new note | NoteRequest | Created note |
| `DELETE` | `/api/v1/notes/{id}` | Delete a note | - | Success message |