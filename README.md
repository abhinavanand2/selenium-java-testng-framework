# 🧪 Selenium Java TestNG Automation Framework

[![Selenium Tests](https://github.com/abhinavanand2/selenium-java-testng-framework/actions/workflows/selenium-tests.yml/badge.svg)](https://github.com/abhinavanand2/selenium-java-testng-framework/actions/workflows/selenium-tests.yml)

A production-style **UI automation framework built with Selenium WebDriver, Java, TestNG and Maven**, demonstrating scalable test automation practices including Page Object Model, reusable components, explicit waits, test-data separation, automatic failure screenshots and CI/CD execution.

The framework automates key e-commerce workflows on **SauceDemo**, including authentication, product/cart operations and an end-to-end checkout journey.

---

## 🚀 Framework Highlights

- Selenium WebDriver + Java
- TestNG test framework
- Maven dependency management and execution
- Page Object Model (POM)
- Reusable `BasePage` component
- Centralized WebDriver management
- Explicit wait strategy using `WebDriverWait`
- Test data separation
- Positive and negative test scenarios
- End-to-end checkout automation
- Chrome browser execution
- Headless execution support
- Automatic screenshots on test failure
- TestNG Listener integration
- GitHub Actions CI/CD
- TestNG/Surefire test reporting

---

## 🛠 Tech Stack

| Technology | Purpose |
|---|---|
| Java | Automation programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and assertions |
| Maven | Build and dependency management |
| Page Object Model | Framework design pattern |
| GitHub Actions | CI/CD automation |
| ChromeDriver | Chrome browser execution |

---

## 🏗 Framework Architecture

```text
selenium-java-testng-framework/
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BasePage.java
│   │   ├── config/
│   │   │   └── ConfigReader.java
│   │   ├── driver/
│   │   │   └── DriverManager.java
│   │   └── pages/
│   │       ├── LoginPage.java
│   │       ├── ProductsPage.java
│   │       ├── CartPage.java
│   │       └── CheckoutPage.java
│   │
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   ├── data/
│       │   │   ├── CheckoutData.java
│       │   │   └── TestDataProvider.java
│       │   ├── listeners/
│       │   │   └── ScreenshotListener.java
│       │   └── tests/
│       │       ├── LoginTest.java
│       │       ├── CartTest.java
│       │       └── CheckoutTest.java
│       └── resources/
│           └── config.properties
│
├── .github/
│   └── workflows/
│       └── selenium-tests.yml
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

## 🧩 Page Object Model

The framework separates test logic from UI interaction logic using the **Page Object Model**.

- `LoginPage` — authentication actions
- `ProductsPage` — product and cart operations
- `CartPage` — cart validation and checkout navigation
- `CheckoutPage` — customer information, checkout overview and order completion
- `BasePage` — reusable Selenium actions and explicit waits

This separation keeps test scenarios readable while reducing duplicated Selenium code.

---

## 🧪 Automated Test Coverage

The current suite contains **6 automated tests** covering key functional and end-to-end scenarios.

| Area | Coverage |
|---|---|
| Login | Valid authentication |
| Login | Invalid authentication / negative validation |
| Products | Product page validation |
| Cart | Add product and validate cart |
| Checkout | Checkout information and navigation |
| E2E | Login → Product → Cart → Checkout → Order confirmation |

Current successful execution:

```text
Tests run: 6
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

## 🛒 End-to-End Scenario

The primary E2E test automates the following customer journey:

```text
Login
  ↓
Products Page
  ↓
Add Sauce Labs Backpack
  ↓
Validate Cart
  ↓
Proceed to Checkout
  ↓
Enter Customer Information
  ↓
Checkout Overview
  ↓
Finish Order
  ↓
Validate Order Confirmation
```

Expected confirmation:

```text
Thank you for your order!
```

---

## ⏱ Synchronization Strategy

The framework uses Selenium `WebDriverWait` and `ExpectedConditions` rather than fixed sleeps.

Reusable synchronization and interaction methods are centralized in `BasePage`, including:

```java
click(...)
type(...)
getText(...)
isDisplayed(...)
waitForUrlContains(...)
waitForVisible(...)
scrollIntoView(...)
```

This approach reduces duplicated synchronization logic and improves test reliability across local and CI executions.

---

## 📸 Failure Diagnostics

A custom **TestNG Listener** automatically captures browser screenshots when a test fails.

Screenshots are stored under:

```text
test-output/screenshots/
```

Example:

```text
userShouldCompleteCheckoutSuccessfully_YYYYMMDD_HHMMSS.png
```

This provides diagnostic evidence for failed local and CI executions.

---

## ▶️ Running the Tests

### Clone the repository

```bash
git clone https://github.com/abhinavanand2/selenium-java-testng-framework.git
cd selenium-java-testng-framework
```

### Run the complete suite

```bash
mvn clean test
```

### Run a specific test

```bash
mvn -Dtest=CheckoutTest test
```

### Run using Chrome

```bash
mvn clean test -Dbrowser=chrome
```

### Run Chrome in headless mode

```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

### Run Chrome with the browser visible

```bash
mvn clean test -Dbrowser=chrome -Dheadless=false
```

---

## 🔄 CI/CD with GitHub Actions

The framework is integrated with **GitHub Actions** for automated test execution.

The CI pipeline:

1. Checks out the repository
2. Sets up the Java environment
3. Resolves Maven dependencies
4. Executes the Selenium + TestNG suite in headless mode
5. Reports the build and test result
6. Preserves configured test artifacts for troubleshooting

Workflow configuration:

```text
.github/workflows/selenium-tests.yml
```

The workflow has been successfully validated in GitHub Actions, providing automated regression execution whenever changes are pushed to the repository.

---

## 🧠 Framework Design Principles

This project demonstrates practical automation framework concepts including:

- Separation of test logic and page interactions
- Reusable browser interaction methods
- Centralized WebDriver lifecycle management
- Configuration-driven browser execution
- Explicit synchronization
- Independent test data
- Automated failure diagnostics
- Headless CI execution
- Maintainable Page Object architecture
- CI/CD integration

---

## 👨‍💻 Author

**Abhinav Anand**

QA Lead / Senior QA Engineer with 9+ years of experience across functional testing, UI automation, API testing and fintech/payment platforms.

**Core automation stack:**  
`Java` • `Selenium` • `TestNG` • `Playwright` • `REST API Testing` • `Maven` • `GitHub Actions`

[LinkedIn](https://www.linkedin.com/in/abhinav-anand-56356022a/) • [GitHub](https://github.com/abhinavanand2)

---

## 📌 QA / SDET Portfolio

This repository is part of my QA/SDET automation portfolio demonstrating practical automation framework design, maintainability, synchronization, failure diagnostics and CI/CD integration.

Other flagship projects:

- **Playwright + TypeScript E2E Automation Framework**
- **Murabaha FinTech QA Automation Framework**
