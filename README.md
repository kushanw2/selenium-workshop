# Selenium Workshop — SLIIT

A hands-on Selenium + Java workshop project for SLIIT 3rd year students.  
Automates a login flow on [SauceDemo](https://www.saucedemo.com) with optional Allure report integration.

---

## Branches

| Branch    | Description                                      |
|-----------|--------------------------------------------------|
| `main`    | Completed solution with all tests and Allure steps |
| `starter` | Skeleton with TODOs — start here for the workshop |

---

## Tech Stack

- Java 17
- Maven 3.9+
- Selenium 4.20.0
- TestNG 7.10.2
- WebDriverManager 5.8.0 (auto ChromeDriver management — no manual driver setup)
- Allure TestNG 2.27.0 *(bonus section)*
- AspectJ Weaver 1.9.22

---

## Demo Site Credentials

| Username         | Password       | Notes                  |
|------------------|----------------|------------------------|
| `standard_user`  | `secret_sauce` | Valid login            |
| `locked_out_user`| `secret_sauce` | Locked-out user        |

---

## Commands

```bash
# Run all tests
mvn clean test

# Generate Allure report (bonus)
mvn allure:report

# Open Allure report in browser (bonus)
mvn allure:serve
```

---

## Project Structure

```
selenium-workshop/
├── pom.xml
├── README.md
└── src/
    └── test/
        ├── java/
        │   └── tests/
        │       ├── BaseTest.java       # WebDriver setup/teardown
        │       └── LoginTest.java      # Login test cases
        └── resources/
            └── testng.xml              # TestNG suite configuration
```
