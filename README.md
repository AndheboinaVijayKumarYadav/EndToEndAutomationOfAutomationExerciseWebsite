# Page Factory Based Selenium Automation Framework (with Java)

**Author**: Andheboina Vijay Kumar Yadav

---

## 📌 Description

This project is a **Selenium Automation Framework** built using **Java**, **Selenium**, and **TestNG**. It is designed to automate end-to-end test scenarios for web applications, support **data-driven testing**, integrate with **cloud platforms**, and generate detailed **Allure reports** for analysis.

---

## 🔧 Features

- **Thread Safety**: Uses `ThreadLocal` to manage WebDriver instances safely in parallel execution.
- **Data-Driven Testing**: Fetches data from Excel via **Apache POI** and TestNG `@DataProvider`.
- **Configuration Handling**: Credentials, URLs, and environment configs stored in `.properties` files.
- **Cross-Browser Execution**: Supports **local**, **Selenoid**, and **cloud** browser execution.
- **Code Quality**: Integrated with **SonarLint** and built on **Java 22+** for modern capabilities.

---

## 🛠️ Technologies Used

| Component            | Tool / Library           |
|----------------------|--------------------------|
| Programming Language | Java (21 or 22+)         |
| Build Tool           | Maven                    |
| Testing Framework    | TestNG                   |
| Browser Automation   | Selenium WebDriver       |
| Assertion Library    | AssertJ                  |
| Reporting            | Allure Reports           |
| Data Handling        | Apache POI, `.properties`|
| Code Quality         | SonarLint                |
| Cloud Grid Support   | BrowserStack, LambdaTest, Selenoid |

---

## 🧱 Project Structure (Maven)

```
automation-framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.automation.base
│   │       └── com.automation.pages
│   │       └── com.automation.utils
│   └── test/
│       └── java/
│           └── com.automation.tests
├── config/
│   └── config.properties
├── testng.xml
├── pom.xml
├── README.md
```

---

## 🧪 How to Run Tests

```bash
mvn clean test
```

To generate Allure Reports (after test run):

```bash
allure serve allure-results
```

---

## 💡 Git & GitHub Workflow

- **Initialize Git (inside WSL)**

```bash
git init
git add .
git commit -m "Initial commit with framework structure"
```

- **Add Remote and Push**

```bash
git remote add origin https://github.com/<your-username>/page-factory-framework.git
git branch -M main
git push -u origin main
```

- **Daily Best Practice**

```bash
git add .
git commit -m "Meaningful message"
git push
```

---

## 🐧 Running in WSL (Windows Subsystem for Linux)

This project is built and executed from **inside WSL (Ubuntu)** for better terminal tools, Linux compatibility, and Git configuration.

### 🔧 Tools Installed in WSL:
- **OpenJDK 21 or 22**
- **Maven**
- **Git**
- **Allure CLI**
- **Nano or Vim for file editing**

### 🔍 Check Installed Tools:

```bash
java -version
mvn -version
git --version
allure --version
```

### 📁 Folder Structure

Project is located in:

```
/home/vijay/Automation-Framework
```

You can edit the project using IntelliJ installed on Windows (accessing WSL folders), or directly work inside IntelliJ if it supports WSL path mapping.

---

## 🔐 Configuration & Secrets

- **config.properties** holds base URLs, usernames, passwords
- Different environments supported: `dev`, `staging`, `prod`
- Sensitive files can be `.gitignore`-d

---

## 📊 Reporting with Allure

- Generate interactive HTML reports after execution
- Contains test history, screenshots, timeline, trends
- Can be integrated into Jenkins/GitHub Actions later

---

## 🌐 Cloud Integration (Planned/Future Scope)

- **BrowserStack**, **LambdaTest** for real device testing
- **Selenoid** for Docker-based grid execution
- Execution controlled via `.properties` and environment flags

---

## ✅ Prerequisites

Make sure these are installed **inside WSL**:

- Java JDK 21 or 22
- Maven
- Git
- Allure Commandline

---

## 🧠 Contributing

Feel free to fork this repo and enhance or refactor it for additional features, like:
- Jenkins CI/CD pipeline
- Docker integration
- Advanced reporting
- Integration with APIs

---

## 🙌 Acknowledgements

This framework was created by **Andheboina Vijay Kumar Yadav** as part of real-world learning and transition to automation excellence.
