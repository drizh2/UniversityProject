# University Console App

A simple **Spring Boot** console application that simulates a university system with departments and lectors.  
Lectors can work in multiple departments, and each lector has a degree (`ASSISTANT`, `ASSOCIATE_PROFESSOR`, `PROFESSOR`).  
All data is stored in a **relational database** (H2 in-memory by default).

---

##  Features

The application supports the following console commands:

1. **Find head of department**

`Who is head of department {department_name}`

**Answer:**

`Head of {department_name} department is {head_of_department_name}`

2. **Show department statistics**

```
assistants - {assistants_count}
associate professors - {associate_professors_count}
professors - {professors_count}
```

**Answer:**

`Head of {department_name} department is {head_of_department_name}`

3. **Show average salary of department**

`Show the average salary for the department {department_name}`

**Answer:**

`The average salary of {department_name} is {average_salary}`

4. **Show employee count of department**

`Show count of employee for {department_name}`

**Answer:**

`Employee count: {employee_count}`

5. **Global search by template**

`Global search by {template}`

**Example:**
`Global search by van`

**Answer:**

`Ivan Petrenko, Petro Ivanov`

---

## Tech Stack

- Java 17 
- Spring Boot 
- Spring Data JPA 
- H2 Database (in-memory)

---

## Run locally
1) Clone the repository:
```
git clone https://github.com/your-username/university-console-app.git
cd university-console-app
```
2) Build and run the project with Maven:
```
mvn spring-boot:run
```
3) The console interface will be started. Type commands as shown above. 
4) To exit the application:
```
exit
```

---

## Project structure

```
src/main/java/com/dadry/universityproject/
 ├── UniversityProjectApplication.java        # Entry point
 ├── entity/                                  # JPA entities (Department, Lector)
 ├── repository/                              # Spring Data repositories
 ├── service/                                 # Business logic (UniversityService)
 └── console/                                 # Console runner (CommandLineRunner)

```

---

## Tests

Run the unit tests with:
`mvn test`
Unit tests cover the main service logic:
- Head of department 
- Department statistics 
- Average salary 
- Employee count 
- Global search

---

## Example usage

```
University console app is running. Type your command:
Who is head of department Computer Science
Head of Computer Science department is Olena Shevchenko

Show Computer Science statistics.
assistants - 1
associate professors - 1
professors - 1

Show the average salary for the department Computer Science
The average salary of Computer Science is 2566.6666666666665

Global search by van
Ivan Petrenko, Petro Ivanov
```