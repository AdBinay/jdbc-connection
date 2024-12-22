# JDBC Connection Example

This repository contains a simple Java application that demonstrates how to connect to a MySQL database using JDBC (Java Database Connectivity). The application performs an `INSERT` operation on a table in the database.

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have JDK installed on your system.
2. **MySQL Database**: Install and configure MySQL on your machine.
3. **MySQL Connector/J**: Add the MySQL JDBC driver (`mysql-connector-java-x.x.x.jar`) to your project's classpath.

## Steps to Run the Application

### 1. Clone the Repository

```bash
git clone <repository_url>
cd <repository_folder>
```

### 2. Set Up the Database

- Create a database named `student_db`.
- Create a table named `tbl_student` with the following schema:

```sql
CREATE TABLE tbl_student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(15)
);
```

### 3. Update Database Credentials

- Open the `App.java` file and update the following variables with your database credentials:

```java
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "root";
String password = "your_password";
```

### 4. Compile and Run the Application

- Compile the program:

```bash
javac App.java
```

- Run the program:

```bash
java App
```

### 5. Verify the Results

- Check the `tbl_student` table in the `student_db` database to ensure the data has been inserted:

```sql
SELECT * FROM tbl_student;
```

## Code Overview

```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Step 2: Loading the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 3: Connecting to the database
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "0935";

        // Step 4: Creating a connection object
        Connection con = DriverManager.getConnection(url, user, password);

        // Step 5: Creating a statement object
        Statement stat = con.createStatement();

        // SQL query
        String str = "INSERT INTO tbl_student(id, name, address, phone) VALUES (1, 'Ram', 'Pokhara', '12345')";

        // Step 6: Execute SQL query
        stat.executeUpdate(str);
        System.out.println("Successfully connected to database");

        // Step 7: Close the connection
        stat.close();
        con.close();
    }
}
```

## Notes

- Ensure the MySQL service is running on your machine.
- Replace the placeholder credentials (`root`, `0935`) with your actual MySQL username and password.
- If using a different version of the MySQL JDBC driver, ensure the `Class.forName("com.mysql.cj.jdbc.Driver")` line matches your driver class name.

## Troubleshooting

### 1. Driver Not Found

- Ensure the MySQL Connector/J JAR file is in your classpath.

### 2. Connection Issues

- Verify the database URL, username, and password.
- Check if the MySQL service is running and accessible.

### 3. SQL Syntax Errors

- Double-check your SQL query for syntax issues.
