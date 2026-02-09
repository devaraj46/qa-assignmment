# SauceDemo Automation Framework

This repository contains an end-to-end UI automation framework for the **SauceDemo** application built using **Selenium WebDriver**, **Java**, **Maven**, **TestNG**, and the **Page Object Model (POM)** design pattern.

The framework is designed to be easy to set up, scalable, and suitable for real-world automation assignments and interviews.

---

## Tech Stack

- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Build Tool:** Maven  
- **Test Framework:** TestNG  
- **Design Pattern:** Page Object Model (POM)  
- **IDE:** Eclipse  

---

## Project Structure

saucedemo-automation
│
├── src
│ ├── main
│ │ └── java
│ │ └── pages # Page Object classes
│ └── test
│ └── java
│ └── tests # TestNG test classes
│
├── testng.xml # Test execution control
├── pom.xml # Maven dependencies
├── README.md


---

## Setup Instructions

### Step 1: Install Java (JDK)

1. Download **Java JDK 8 or higher**  
   https://www.oracle.com/java/technologies/downloads/
2. Install the JDK.
3. Verify installation:


---

### Step 2: Install Eclipse IDE

1. Download **Eclipse IDE for Java Developers**  
https://www.eclipse.org/downloads/
2. Install and open Eclipse.

---

### Step 3: Install Maven

1. Download Maven  
https://maven.apache.org/download.cgi
2. Extract the ZIP file.
3. Set `MAVEN_HOME` and add Maven `bin` to system `PATH`.
4. Verify installation:



> Note: Eclipse comes with built-in Maven support (m2e). External Maven installation is optional.

---

### Step 4: Import Project into Eclipse

1. Open Eclipse
2. Go to **File → Import**
3. Select **Existing Maven Projects**
4. Browse to the project directory
5. Click **Finish**

---

### Step 5: Resolve Dependencies

Maven automatically downloads all dependencies defined in `pom.xml`.

If required:
- Right-click project  
- Select **Maven → Update Project**

---

## How to Run Tests

### Option 1: Run Using TestNG XML

1. Right-click `testng.xml`
2. Select **Run As → TestNG Suite**

---

### Option 2: Run Individual Test Class

1. Navigate to any test class under `src/test/java`
2. Right-click the class
3. Select **Run As → TestNG Test**

---

### Option 3: Run Using Maven


> Note: Eclipse comes with built-in Maven support (m2e). External Maven installation is optional.

---

### Step 4: Import Project into Eclipse

1. Open Eclipse
2. Go to **File → Import**
3. Select **Existing Maven Projects**
4. Browse to the project directory
5. Click **Finish**

---

### Step 5: Resolve Dependencies

Maven automatically downloads all dependencies defined in `pom.xml`.

If required:
- Right-click project  
- Select **Maven → Update Project**

---

## How to Run Tests

### Option 1: Run Using TestNG XML

1. Right-click `testng.xml`
2. Select **Run As → TestNG Suite**

---

### Option 2: Run Individual Test Class

1. Navigate to any test class under `src/test/java`
2. Right-click the class
3. Select **Run As → TestNG Test**

### Framework Choice Justification

Selenium with Java is a widely adopted and industry-proven automation stack, making it suitable for scalable and maintainable 
UI test automation. Maven simplifies dependency management and build execution, while TestNG provides flexible execution control through 
annotations and XML configuration. The Page Object Model ensures clear separation between test logic and UI elements, improving readability and long-term maintainability.




