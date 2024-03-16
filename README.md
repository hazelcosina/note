# Getting Started

### Reference Documentation
This is a simple Note Application API that lets you create a note, view it, update and delete it.

### API Endpoints

* POST /notes: Create a new note.
* GET /notes: Retrieve all notes.
* GET /notes/:id: Retrieve a specific note by ID.
* PUT /notes/:id: Update a specific note.
* DELETE /notes/:id: Delete a specific note.

### Environment
* Java 11
* Maven 3.6.3

### How to run
To run the application locally, follow these steps:
1. Clone the repository: https://github.com/hazelcosina/note/
2. Navigate to the project directory: note/
3. Build the project using Maven in cmd:
mvn clean install
4. Run the application in cmd:
mvn spring-boot:run

### Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

