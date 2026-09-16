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
│   │   │
│   │   ├── config/
│   │   │   └── ConfigReader.java
│   │   │
│   │   ├── driver/
│   │   │   └── DriverManager.java
│   │   │
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
│       │
│       └── resources/
│           └── config.properties
│
├── .github/
│   └── workflows/
│       └── selenium-tests.yml
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

## 🧩 Page Object Model

The framework separates test logic from UI interaction logic using the **Page Object Model**.

Examples:

- `LoginPage` — authentication actions
- `ProductsPage` — product and cart operations
- `CartPage` — cart validation and checkout navigation
- `CheckoutPage` — customer information, checkout overview and order completion
- `BasePage` — reusable Selenium actions and explicit waits

This keeps tests readable and reduces duplicated Selenium code.

---

## 🧪 Automated Test Coverage

The current suite contains **6 automated tests** covering major functional flows.

| Area | Coverage |
|---|---|
| Login | Valid authentication |
| Login | Invalid authentication / negative validation |
| Products | Product page validation |
| Cart | Add product and validate cart |
| Checkout | Checkout information and navigation |
| E2E | Login → Product → Cart → Checkout → Order confirmation |

Current execution result:

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

## ⏱ Explicit Wait Strategy

The framework uses `WebDriverWait` and Selenium `ExpectedConditions` instead of relying on fixed sleeps.

Reusable synchronization methods are implemented in `BasePage`, including:

```java
click(...)
type(...)
getText(...)
isDisplayed(...)
waitForUrlContains(...)
waitForVisible(...)
scrollIntoView(...)
```

This improves test stability and keeps synchronization logic centralized.

---

## 📸 Automatic Screenshots on Failure

A custom **TestNG Listener** automatically captures browser screenshots whenever a test fails.

Failure screenshots are stored under:

```text
test-output/screenshots/
```

Example:

```text
userShouldCompleteCheckoutSuccessfully_YYYYMMDD_HHMMSS.png
```

This makes failed CI/local executions easier to investigate without manually reproducing every failure.

---

## ▶️ Running the Tests

Clone the repository:

```bash
git clone https://github.com/abhinavanand2/selenium-java-testng-framework.git
cd selenium-java-testng-framework
```

Run the complete suite:

```bash
mvn clean test
```

Run only the checkout test:

```bash
mvn -Dtest=CheckoutTest test
```

Run using Chrome:

```bash
mvn clean test -Dbrowser=chrome
```

Run Chrome in headless mode:

```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

Run Chrome with the browser visible:

```bash
mvn clean test -Dbrowser=chrome -Dheadless=false
```

---

## 🔄 CI/CD with GitHub Actions

The framework is integrated with **GitHub Actions**.

The CI pipeline automatically:

1. Checks out the repository
2. Sets up the Java environment
3. Installs project dependencies through Maven
4. Executes the Selenium + TestNG suite
5. Reports the build result
6. Preserves relevant test artifacts when configured

Workflow:

```text
.github/workflows/selenium-tests.yml
```

The CI status badge at the top of this README provides quick visibility into the latest pipeline status.

---

## 🧠 Framework Design Principles

The project demonstrates automation practices commonly used in maintainable QA frameworks:

- Separation of tests and page objects
- Reusable browser interaction methods
- Centralized driver management
- Configuration-driven execution
- Explicit synchronization
- Independent test data
- Failure diagnostics
- CI-ready execution
- Readable test scenarios

---

## 👨‍💻 Author

**Abhinav Anand**

QA Lead / Senior QA Engineer with 9+ years of experience across functional testing, UI automation, API testing and fintech/payment platforms.

Core automation stack:

`Java` • `Selenium` • `TestNG` • `Playwright` • `REST API Testing` • `Maven` • `GitHub Actions`

[LinkedIn](https://www.linkedin.com/in/abhinav-anand-56356022a/) | [GitHub](https://github.com/abhinavanand2)

---

## 📌 Portfolio

This repository is part of my QA/SDET automation portfolio demonstrating practical test automation framework design, maintainability, failure diagnostics and CI/CD integration.

Additional portfolio projects include:

- **Playwright + TypeScript E2E Automation Framework**
- **FinTech / Murabaha QA Automation Framework**
