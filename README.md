
# QAP 4 – Advanced Java: Persisting Data

## 📌 Project Description
This is a console-based Java application that demonstrates two common approaches to data persistence:

- **Saving Drug objects to a text file using CSV format**
- **Saving Patient objects to a PostgreSQL database using JDBC**

---

## 🏗️ Project Structure

```
QAP4/
├── src/
│   ├── Main.java              # Main class with menu
│   ├── Drug.java              # Drug entity class
│   ├── Patient.java           # Patient entity class
│   ├── FileManager.java       # Handles file operations
│   └── DatabaseManager.java   # Handles database operations
├── patient_table.sql          # SQL script for table creation
├── drug_data.txt              # Text file (auto-generated)
└── README.md                  # This file
```

---

## 🧩 Application Features

### 1. Drug Management
- ✅ Save Drug objects to a text file in CSV format
- ✅ Read all Drug objects from the file
- ✅ Auto-create the file if it doesn't exist
- ✅ Handles file I/O errors gracefully

### 2. Patient Management
- ✅ Save Patient objects to a PostgreSQL database
- ✅ Read all Patient records from the database
- ✅ Automatically create the table if needed
- ✅ Includes database connection testing

---

## ⚙️ Setup and Installation

### Requirements
- Java JDK 8 or higher
- PostgreSQL Database
- PostgreSQL JDBC Driver

### Database Setup
1. **Install PostgreSQL**
2. **Create the database:**

```sql
CREATE DATABASE qap4_database;
```

3. **Run the SQL script:**

```bash
psql -d qap4_database -f patient_table.sql
```

4. **Update the connection parameters in `DatabaseManager.java`:**

```java
private static final String URL = "jdbc:postgresql://localhost:5432/qap4_database";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

---

### Compile and Run

```bash
# Navigate to src folder
cd src

# Compile all classes
javac *.java

# Run the app
java Main
```

---

## 🎮 How to Use

Upon launching, the following menu will appear:

```
=== MAIN MENU ===
1. Save Drug to text file
2. Read all Drugs from text file
3. Save Patient to database
4. Read all Patients from database
5. Test database connection
0. Exit
```

### Example – Drug:
1. Choose option 1
2. Enter: ID: 101, Name: Aspirin, Cost: 15.50, Dosage: 500mg
3. The data will be saved to `drug_data.txt`

### Example – Patient:
1. Choose option 3
2. Enter: ID: 1, First Name: John, Last Name: Doe, DOB: 1985-05-15
3. The data will be saved to the PostgreSQL database

---

## 📁 Data Formats

### Drug (CSV format in file)
```
101,Aspirin,15.50,500mg
102,Ibuprofen,12.75,400mg
```

### Patient (PostgreSQL table)
```sql
CREATE TABLE patients (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL
);
```

---

## 🛠️ Technical Details

### Error Handling
- ✅ User input validation
- ✅ File system error handling
- ✅ Database error handling
- ✅ Clear error messages

### Security
- ✅ Uses PreparedStatement to prevent SQL injection
- ✅ Uses try-with-resources to auto-close resources
- ✅ Data validation at all stages

---

## 🎯 Learning Objectives

This project helped me demonstrate:
- File-based persistence: Writing and reading objects using CSV
- Relational persistence: Using JDBC with PostgreSQL
- Application architecture: Logical separation into classes
- Exception handling: Graceful handling of runtime errors
- User interface: Simple console-based menu

---

## 🤔 Development Reflection

**Challenges:**
- Setting up PostgreSQL and configuring JDBC connection
- Handling various types of exceptions
- Designing an intuitive console interface

**What I Learned:**
- Using JDBC API to connect and interact with databases
- File I/O operations in Java
- Best practices for error handling
- Organizing code into manageable classes

**Time Spent:**
Approximately 6–8 hours total:
- Architecture planning: 1 hour
- Implementing entity and manager classes: 3 hours
- Database setup and testing: 2 hours
- Debugging and testing: 2 hours

---

## 📝 Notes

- `drug_data.txt` is automatically created when saving the first Drug
- The `patients` table is created manually but can be auto-checked
- The app tests the database connection before performing operations
- All inputs are validated before processing

sql
Copy
Edit
CREATE DATABASE qap4_database;
Run the SQL script:

bash
Copy
Edit
psql -d qap4_database -f patient_table.sql
Update the connection parameters in DatabaseManager.java:

java
Copy
Edit
private static final String URL = "jdbc:postgresql://localhost:5432/qap4_database";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
Compile and Run
bash
Copy
Edit
# Navigate to src folder
cd src

# Compile all classes
javac *.java

# Run the app
java Main
🎮 How to Use
Upon launching, the following menu will appear:

pgsql
Copy
Edit
=== MAIN MENU ===
1. Save Drug to text file
2. Read all Drugs from text file
3. Save Patient to database
4. Read all Patients from database
5. Test database connection
0. Exit
Example – Drug:
Choose option 1

Enter: ID: 101, Name: Aspirin, Cost: 15.50, Dosage: 500mg

The data will be saved to drug_data.txt

Example – Patient:
Choose option 3

Enter: ID: 1, First Name: John, Last Name: Doe, DOB: 1985-05-15

The data will be saved to the PostgreSQL database

📁 Data Formats
Drug (CSV format in file)
Copy
Edit
101,Aspirin,15.50,500mg
102,Ibuprofen,12.75,400mg
Patient (PostgreSQL table)
sql
Copy
Edit
CREATE TABLE patients (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL
);
🛠️ Technical Details
Error Handling
✅ User input validation

✅ File system error handling

✅ Database error handling

✅ Clear error messages

Security
✅ Uses PreparedStatement to prevent SQL injection

✅ Uses try-with-resources to auto-close resources

✅ Data validation at all stages

🎯 Learning Objectives
This project helped me demonstrate:

File-based persistence: Writing and reading objects using CSV

Relational persistence: Using JDBC with PostgreSQL

Application architecture: Logical separation into classes

Exception handling: Graceful handling of runtime errors

User interface: Simple console-based menu

🤔 Development Reflection
Challenges:
Setting up PostgreSQL and configuring JDBC connection

Handling various types of exceptions

Designing an intuitive console interface

What I Learned:
Using JDBC API to connect and interact with databases

File I/O operations in Java

Best practices for error handling

Organizing code into manageable classes

Time Spent:
Approximately 6–8 hours total:

Architecture planning: 1 hour

Implementing entity and manager classes: 3 hours

Database setup and testing: 2 hours

Debugging and testing: 2 hours

📝 Notes
drug_data.txt is automatically created when saving the first Drug

The patients table is created manually but can be auto-checked

The app tests the database connection before performing operations

All inputs are validated before processing