# 🧪 Automation Exercise – REST API Testing Project

## 📌 Overview

This project automates the API testing for [AutomationExercise.com](https://automationexercise.com), a practice website for testing real-world API scenarios.

The test suite covers 14 REST API endpoints across user management, product search, login, and account operations.

---

## 🧰 Tech Stack

* **Language**: Java
* **Framework**: TestNG
* **API Automation Tool**: REST Assured, Selenium WebDriver
* **Test Design**: Data-Driven & Hybrid
* **Build Tool**: Maven
* **Reporting**: Allure Reports, Extent Reports
* **Utilities**: JSON Schema Validator, Jackson, Gson, Java Faker

---

## 🔗 API Coverage

| #  | API Description                 | Method | Endpoint                    | Expected Status |
| -- | ------------------------------- | ------ | --------------------------- | --------------- |
| 1  | Get all products                | GET    | `/api/productsList`         | 200             |
| 2  | Invalid POST on products list   | POST   | `/api/productsList`         | 405             |
| 3  | Get all brands                  | GET    | `/api/brandsList`           | 200             |
| 4  | Invalid PUT on brands list      | PUT    | `/api/brandsList`           | 405             |
| 5  | Search product with valid query | POST   | `/api/searchProduct`        | 200             |
| 6  | Search product without query    | POST   | `/api/searchProduct`        | 400             |
| 7  | Login with valid credentials    | POST   | `/api/verifyLogin`          | 200             |
| 8  | Login without email             | POST   | `/api/verifyLogin`          | 400             |
| 9  | Invalid DELETE on login         | DELETE | `/api/verifyLogin`          | 405             |
| 10 | Login with invalid credentials  | POST   | `/api/verifyLogin`          | 404             |
| 11 | Create/Register user account    | POST   | `/api/createAccount`        | 201             |
| 12 | Delete user account             | DELETE | `/api/deleteAccount`        | 200             |
| 13 | Update user account             | PUT    | `/api/updateAccount`        | 200             |
| 14 | Get user details by email       | GET    | `/api/getUserDetailByEmail` | 200             |

---

## 📁 Project Structure

```
automation-exercise-api/
│
├── src/
│   └── test/
│       └── java/
│           ├── payloads/
│           │   └── Payload.java
│           │     (Dynamic data creation using Java Faker)
│           │
│           ├── pojo/
│           │   ├── Login.java
│           │   ├── User.java
│           │
│           ├── routes/
│           │   └── Routes.java
│           │     (Contains all API endpoints centrally)
│           │
│           ├── testcases/
│           │   ├── BaseClass.java
│           │   ├── ProductTests.java
│           │   ├── BrandTests.java
│           │   ├── LoginTests.java
│           │   ├── UserTests.java
│           │   └── SearchTests.java
│           │
│           └── utils/
│               ├── ConfigReader.java
│               ├── DataProviders.java
│               └── ExtentReporter.java
│
├── src/test/resources/
│   ├── config.properties
│
├── testdata/
│   └── productsTestData.json
│
├── logs/
│   └── execution.log
│
├── reports/
│   └── ExtentReport.html
│
├── allure-results/
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## ✅ Test Scenarios

### Functional Validations:

* Status codes, headers, and payload validation
* Positive and Negative cases
* Valid and Invalid payloads for authentication and search
* Response attribute verification using `assertThat`
* JSON Schema validation

### Sample Validation Points:

* `GET` all products returns 200 and expected product list
* `POST` login with invalid credentials returns 404
* `POST` account creation returns 201 with "User created!" message
* `DELETE` user account returns 200 and confirmation message

---

## ⚙️ Setup & Execution

### 1. Prerequisites

* Java 8 or above
* Maven
* IDE (e.g., IntelliJ or Eclipse)
* Allure commandline (for viewing Allure Reports)

### 2. Run Tests

#### Using Maven:

```bash
mvn clean test
```

#### View Allure Report:

```bash
allure serve allure-results
```

---

## 📦 Maven Dependencies

```Key libraries included in pom.xml:
rest-assured
testng
json-path, xml-path
json-schema-validator
gson, jackson-databind
javafaker
scribejava-apis
allure-testng
extentreports
Maven Surefire and Compiler plugins

```

---

## 🧪 Reporting

* **Allure Reports**: Beautiful and detailed test report.
* **Extent Reports**: HTML reports with pass/fail/log details.
* **Logs**: Execution logs generated per test run.

---

## ✍️ Contributions

This is a practice project and open for learners and QA engineers to contribute, improve scenarios, or add test data variations.

---
