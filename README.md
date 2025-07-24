
# QAP 4 – Advanced Java: Persisting Data

## Project Description
Console-based Java application for:
- Saving Drug objects to a text file (CSV)
- Saving Patient objects to a PostgreSQL database (JDBC)

## Project Structure
```
QAP4/
├── src/
│   ├── Main.java
│   ├── Drug.java
│   ├── Patient.java
│   ├── FileManager.java
│   ├── DatabaseManager.java
│   ├── TestScript.java
│   └── DemoScript.java
├── patient_table.sql
├── run_tests.bat/.sh
├── drug_data.txt
└── README.md
```

## Quick Start
**Automated Demo:**
```bash
cd src
javac *.java
java DemoScript
```
**Interactive Mode:**
```bash
cd src
javac *.java
java Main
```
**Automated Testing:**
```bash
cd src
javac *.java
java TestScript
```

## Features
- Save/read Drug objects to/from file (CSV)
- Save/read Patient objects to/from PostgreSQL
- Auto-create file/table if needed
- Error handling and validation
- DATE type support for birth dates

## Setup
**Requirements:**
- Java JDK 8+
- PostgreSQL
- PostgreSQL JDBC Driver

**Database Setup:**
1. Install PostgreSQL
2. Create database:
   ```sql
   CREATE DATABASE qap4_database;
   ```
3. Run SQL script:
   ```bash
   psql -d qap4_database -f patient_table.sql
   ```
4. Update `DatabaseManager.java`:
   ```java
   private static final String URL = "jdbc:postgresql://localhost:5432/qap4_database";
   private static final String USER = "postgres";
   private static final String PASSWORD = "your_password";
   ```

## Usage
**Menu:**
```
1. Save Drug to text file
2. Read all Drugs from text file
3. Save Patient to database
4. Read all Patients from database
5. Test database connection
0. Exit
```

## Data Formats
**Drug (CSV):**
```
101,Aspirin,15.50,500mg
102,Ibuprofen,12.75,400mg
```
**Patient (PostgreSQL):**
```sql
CREATE TABLE patients (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL
);
```

## Testing
**Automated:**
```bash
java TestScript
```
**Manual:** See `TESTING_GUIDE.md`
**Demo:**
```bash
java DemoScript
```

## Notes
- All inputs are validated
- Error messages are clear
- DATE type is handled properly
- **Application architecture**: Logical separation into classes
- **Exception handling**: Graceful handling of runtime errors
- **User interface**: Simple console-based menu
- **Date handling**: Proper conversion between String and java.sql.Date

---

## 🤔 Development Reflection

**Challenges:**
- Setting up PostgreSQL and configuring JDBC connection
- Handling various types of exceptions
- Designing an intuitive console interface
- Proper DATE type handling in PostgreSQL

**What I Learned:**
- Using JDBC API to connect and interact with databases
- File I/O operations in Java
- Best practices for error handling
- Organizing code into manageable classes
- Working with SQL DATE types vs String representations

**Time Spent:**
Approximately 8-10 hours total:
- Architecture planning: 1 hour
- Implementing entity and manager classes: 4 hours
- Database setup and testing: 2 hours
- Debugging and testing: 2 hours
- Documentation and testing scripts: 1 hour

---

## 📝 Project Status

### ✅ Completed Features:
- ✅ Drug file operations (CSV persistence)
- ✅ Patient database operations (PostgreSQL)
- ✅ Interactive menu system
- ✅ Comprehensive error handling
- ✅ Automated testing suite
- ✅ Automated demonstration
- ✅ Proper date handling
- ✅ Complete documentation

### 🎉 Final Result:
All requirements met! The application successfully demonstrates both file-based and database persistence with proper error handling and a clean user interface.

---

## 📸 Demo Results

**File Operations:**
- Successfully saves and reads Drug objects
- Clean CSV format maintained
- Error handling for file I/O

**Database Operations:**  
- PostgreSQL connection working
- Patient data properly stored with DATE types
- Automatic table creation
- Robust error handling

**Testing Results:**
- 15/15 tests passing when database configured
- 10/15 tests passing without database (expected)
- All core functionality verified

---

**Ready for submission! 🚀**

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