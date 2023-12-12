
# Student Performance Forecasting System

The Student Performance Forecasting System is a Java-based application developed using Eclipse IDE, featuring a Swing GUI for streamlined student data management. This system encompasses modules for recording and managing student social activities and sports participation, leveraging a MySQL database for data storage. XAMPP is employed for MySQL database management.

## Screenshots

![App Screenshot](https://drive.google.com/file/d/1HBHPeekytOE2_gWvhNxaLTZ_lYQG-MZy/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/1tybDdLgtI4yKiAmzCO6k4WFJsVwlM5mC/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/1vKEjYBxpLTMBDkg_QTHsJp6Eggfpb1Qe/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/19hZJtZl37r8dWBAc2KJX-OmofJ-esZHe/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/1WzSSurKUfCHw2ozEi8TemMS-7O-agziJ/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/1B20TTuc6SJ1i9l-yzdjt0FaMgfYns8zT/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/1DtUYoBr9nP3y_fKtrXri4IeDFmyxqIaH/view?usp=sharing)

![App Screenshot](https://drive.google.com/file/d/1nGnWBzKb4UnDyoYfWsLbS1wwC4j20cnK/view?usp=sharing)


## Installation

Certainly! Here are the simplified steps to run the project:

1. **Download and Install Eclipse:**
   - Download Eclipse IDE from [eclipse.org](https://www.eclipse.org/downloads/).
   - Install Eclipse on your machine.

2. **Download and Install XAMPP:**
   - Download XAMPP from [apachefriends.org](https://www.apachefriends.org/download.html).
   - Install XAMPP, which includes MySQL.

3. **Import the Project to Eclipse:**
   - Clone or download the project from the GitHub repository.
   - Open Eclipse and import the project.

4. **Create Database and Tables:**
   - Open XAMPP and start the MySQL server.
   - Using the SQL script or provided information, create a database named `oop`.
   - Create the required tables using the provided column details.

5. **Update Database Connection:**
   - In the project source code, locate the database connection settings (usually in a file named `SqlConnection.java`).
   - Update the connection details (username, password, etc.) to match your local MySQL setup.

6. **Run the Project:**
   - Build and run the project in Eclipse.
   - Ensure that the XAMPP MySQL server is running.

7. **Test the Application:**
   - Open the web browser and go to [http://localhost/phpmyadmin/](http://localhost/phpmyadmin/).
   - Verify that the `oop` database and tables have been created.
   - Use the application to interact with the data as needed.


#### Tables and Column Details:

 **Table: admin**
   - Columns:
     - UserID (VARCHAR)
     - UserName (VARCHAR)
     - Password (VARCHAR)

 **Table: studentinfo**
   - Columns:
     - SID (VARCHAR)
     - Name (VARCHAR)
     - Surname (VARCHAR)
     - Age (INT)
     - Email (VARCHAR)

 **Table: marks**
   - Columns:
     - StudentID (VARCHAR)
     - PS (INT)
     - OOP (INT)
     - DSA (INT)
     - RS (INT)
     - AE (INT)
     - DE (INT)
     - TotalScore (INT)
     - Average (INT)
     - Ranking (VARCHAR)

 **Table: aesthetic**
   - Columns:
     - SID (VARCHAR)
     - Name (VARCHAR)
     - Activity (VARCHAR)
     - Event (INT)
     - Award (INT)

 **Table: social**
   - Columns:
     - SID (VARCHAR)
     - Name (VARCHAR)
     - Club (VARCHAR)
     - Year (VARCHAR)
     - Positions (VARCHAR)

 **Table: activity**
   - Columns:
     - SID (VARCHAR)
     - Age  (VARCHAR)
     - Club  (VARCHAR)
     - CID  (VARCHAR)

 **Table: sport**
   - Columns:
     - SID (VARCHAR)
     - Name (VARCHAR)
     - Scode (VARCHAR)
     - Sport (VARCHAR)
     - Achievement (VARCHAR)

**Note:** Ensure you have the required MySQL JDBC driver in your project's classpath. Customize the database connection details as needed.
