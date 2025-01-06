# Online Personal Finance Management System

## Table of Contents
1. [Introduction](#introduction)
2. [Architecture](#architecture)
3. [Features](#features)
4. [Setup and Installation](#setup-and-installation)
5. [Application Workflow](#application-workflow)
6. [Troubleshooting](#troubleshooting)
7. [Future Enhancements](#future-enhancements)
8. [License](#license)

---

## Introduction
The **Personal Expense Tracker** is a Java-based web application designed to help users track and manage their personal expenses. Built using a combination of Servlets, JSP, and JDBC, the application ensures a secure and user-friendly experience. The project follows a modular design with a separation of concerns to simplify maintenance and scalability.

---

## Architecture

### Technologies Used
- **Backend**: Java (Servlets, JDBC)
- **Frontend**: HTML, CSS, JavaScript, JSP
- **Database**: MySQL
- **Server**: Apache Tomcat
- **Build Tool**: Maven
- **Testing**: JUnit

### Design Patterns
- **MVC (Model-View-Controller)**: For clear separation between data, business logic, and user interface.
- **DAO (Data Access Object)**: For database operations.

---

## Features
- **User Registration**: Register with a unique username and email.
- **Login/Logout**: Secure login and session management.
- **Expense Tracking**: Add, edit, and delete expenses.
- **Profile Management**: Update personal details.
- **Dynamic Dashboards**: Display aggregated expense data.
- **Responsive UI**: Optimized for desktop and mobile.

---

## Setup and Installation

### Prerequisites
1. Install **Java 8+** and set up the `JAVA_HOME` environment variable.
2. Install **Apache Tomcat 9+**.
3. Install **MySQL 5.7+** and create the required database.
4. Install **Maven** for dependency management.

### Steps
1. Clone the Repository:
   ``` bash
   git clone https://github.com/your-repo/personal-expense-tracker.git
   cd personal-expense-tracker
   ```
### Set Up Database:
Run the SQL script in creating.sql to set up tables.
Update database credentials in DatabaseConnection.java:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/expense_tracker";
private static final String DB_USER = "your_username";
private static final String DB_PASSWORD = "your_password";
```
### Build the Project:
```bash
mvn clean install
```
### Deploy to Tomcat:
Copy the WAR file from the target directory to Tomcat's webapps folder.
Start the Tomcat server and access the app at http://localhost:8080/personal-expense-tracker.

## Application Workflow
### User Journey
1. Registration: Users sign up with unique credentials.
2. Login: Users log in and are redirected to the dashboard.
3. Expense Management: Add, edit, and delete expenses via the dashboard.
4. Profile: Update profile details on the profile page.
5. Logout: Securely end the session.
### Interaction Diagram
1. Frontend: HTML forms send data via HTTP requests.
2. Backend: Servlets handle requests, process data, and interact with the database.
3. Database: Stores user and expense data persistently.

## Troubleshooting

| Issue                     | Solution                                                                  |
|---------------------------|-------------------------------------------------------------------------- |
| Database connection error | Verify credentials and database URL in `DatabaseConnection`.              |
| Tomcat deployment issues  | Check the server logs for errors.                                         |
| CSS/JS not loading        | Ensure files are correctly linked and paths are accurate.                 |
| Session timeout           | Adjust session timeout in `web.xml`.                                      |


## Future Enhancements
Implement expense categories for better tracking.

Add charts to visualize expense trends.

Enable file uploads for receipt storage.

Introduce multi-currency support.

## License
This project is licensed under the [MIT License](https://github.com/anayush87/PERSONAL-FINANCE-MANAGEMENT-PLATFORM/blob/main/LICENSE).
