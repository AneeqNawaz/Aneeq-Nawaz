# 🧪 User API Test Automation Framework (CRUD + Docker)

This repository contains an automated API test framework for validating CRUD operations against the **Swagger Petstore's USER endpoint**. The goal is to provide a clean, maintainable, and scalable Python-based testing solution using industry best practices.

---

## 📦 Tech Stack

| Component       | Purpose                                   |
|----------------|-------------------------------------------|
| Python 3.11     | Core programming language                 |
| Pytest          | Test runner & structure                   |
| Faker           | Dynamic user data generation              |
| Requests        | HTTP client to interact with API          |
| Pytest-HTML     | HTML-based test reports                   |
| Docker          | Containerized execution environment       |

---

## ⚙️ Setup Instructions

1. **Clone the repository**

```
git clone https://github.com/your-username/api_basicCRUD_test.git](https://github.com/AneeqNawaz/api_basicCRUD_test.git
cd api_basicCRUD_test
```

2. **Create and activate a virtual environment (optional)**
```
python -m venv venv
source venv/bin/activate  # or venv\Scripts\activate on Windows
```
3. **Install dependencies**
```
pip install -r requirements.txt
```
🚀 **Running Tests Locally**
```
pytest --html=reports/report.html --self-contained-html
```
This will:
- Execute all CRUD tests
- Generate a detailed HTML report in reports/report.html

---
## 🐳 Running Tests via Docker (Preferred)

No manual setup needed! Just build and run inside a clean, containerized environment.

### ✅ Build the Docker image

```bash
docker build -t petstore-tests .
```
✅ Run the tests and export the HTML report

💻 For Windows (CMD):
```
docker run --rm -v "%cd%\reports:/app/reports" petstore-tests
```

🍎 For macOS / Linux:
```
docker run --rm -v "$(pwd)/reports:/app/reports" petstore-tests
```
📁 This maps the container's /app/reports directory to your local ./reports folder.
After running, open reports/report.html in your browser to view the results.

**Make sure the reports/ folder exists before running, or create it manually with mkdir reports.**

---
🔎 Project Structure
```
.
├── apis/                      # API wrapper layer
│   └── user_api.py
├── utils/                     # Helpers & test data generators
│   ├── config.py
│   └── data_generator.py
├── tests/                     # Modular tests
│   ├── test_user_create.py
│   ├── test_user_read.py
│   ├── test_user_update.py
│   ├── test_user_delete.py
│   └── test_user_negative.py
├── Dockerfile
├── requirements.txt
├── pytest.ini
└── README.md
---
```
## ✍️ Testing Approach & Design Philosophy

✅ Modular test files: Each operation is independently tested (create, read, update, delete).

✅ Dynamic data: Faker ensures every test runs with unique, real-world data—no collisions or stale state.

✅ Test isolation: Each test creates and manages its own user data for reliability and reusability.

✅ Retry & timing safeguards: API delays are handled gracefully using controlled retries (sleep or loops).  

✅ HTML reports: Easy-to-read artifact for stakeholders to track test coverage and results.

✅ Dockerized execution: Platform-independent, reproducible tests for any CI/CD environment.

---
## 📈 Sample Report Preview

✅ Located in reports/report.html after any test run

Includes:

- Pass/fail summary
- Timestamped logs
- Rich HTML structure with test details
---

👨‍💻 Author
Aneeq Nawaz