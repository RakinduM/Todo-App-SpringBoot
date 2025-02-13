# To-Do List Application

## Description
This is a simple To-Do List application built using Spring Boot, JSP, and MySQL. It allows users to add, edit, mark complete, and delete to-do items.

## Features
- Add new to-do items
- Edit existing to-do items
- Mark items as completed
- Delete items
- Display all to-do items in a table

## Technologies Used
- Java (Spring Boot)
- JSP with JSTL
- MySQL
- Bootstrap for styling
- jQuery & Toastr.js for notifications

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/RakinduM/todo-app.git
cd todo-app
```

### 2. Configure the Database
- Copy the `.env.example` file to `.env`
```sh
cp .env.example .env
```
- Open `.env` and update the database configuration:
```
DATABASE_URL=jdbc:mysql://localhost:3306/todo_app
DATABASE_USERNAME=root
```

### 3. Create the Database
```sql
CREATE DATABASE todo_app;
```

### 4. Run the Application
```sh
./mvnw spring-boot:run
```

### 5. Access the Application
- Open your browser and go to: `http://localhost:8080`

## Notes
- Default status for new to-do items is **Incomplete**.
- Dates are formatted as **YY-MM-DD**.


