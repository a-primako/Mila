# Mila 🚀

«Мила» - сеть магазинов, которая предлагает своим клиентам широкий выбор косметики, парфюмерии и бытовой химии.

Mila — Автоматизированный тестовый фреймворк для комбинированного тестирования (API + UI) с использованием современных
инструментов и паттернов.

---

## 🛠 Технологии

- Язык: Java 21
- Тестирование API: REST Assured
- Тестирование UI: Selenium WebDriver
- Тест-раннер: JUnit 5
- Логирование: Logback
- Паттерны: Page Factory, Singleton
- Сборка: Maven

### 📚 Используемые библиотеки

- JUnit Jupiter 5 (5.11.0) — фреймворк для модульного тестирования
- RestAssured (4.4.0) — библиотека для тестирования REST API
- JSON Java (20210307) — работа с JSON-данными
- WebDriverManager (5.8.0) — автоматическое управление веб-драйверами
- Selenium (4.29.0) — автоматизация браузеров
    - selenium-devtools-v133 — интеграция с Chrome DevTools
- AssertJ (3.24.2) — fluent-assertions для тестов
- Allure JUnit5 (2.29.1) — генерация красивых отчетов
- Logback (1.4.14) — логирование
- AspectJ Weaver (1.9.22.1) — поддержка аспектно-ориентированного программирования

### 🛠 Инструменты

- Maven Surefire Plugin (3.2.5) — запуск тестов
- Allure Maven Plugin (2.15.2) — интеграция Allure с Maven

### 📂 Структура проекта

```
src/
└── 📁 main/
└── 📁 java/
└── 📁 by.mila/
├── 🌐 api/
│ └── 📁 utils/
│ ├── 🧩 BaseApiTest.java # 🛠 Базовый класс для API-тестов
│ └── 📄 JsonUtils.java # 📦 Утилиты для работы с JSON
└── 🖥 ui/
├── 📂 pages/
│ ├── 🦶 FooterPage.java # 🧱 Page Object для футера
│ ├── 🔑 LoginPage.java # 🖌 Page Object для страницы входа
│ ├── 🍔 MenuPage.java # 📑 Page Object для меню
│ └── 🔍 SearchPage.java # 🕵️ Page Object для поиска
└── 📁 utils/
└── ⚙️ Singleton.java # 🧬 Паттерн Singleton для драйвера

test/
└── 📁 java/
└── 📁 by.mila/
├── 🌐 api/
│ ├── 🧪 GetApiTest.java # ✅ Тесты GET-запросов
│ └── 🧪 LoginApiTest.java # 🔐 Тесты API авторизации
└── 🖥 ui/
├── 🧪 FooterTest.java # 📜 Тесты футера
├── 🧪 LoginTest.java # 🔓 Тесты авторизации
├── 🧪 MenuTest.java # 📋 Тесты меню
└── 🧪 SearchTest.java # 🔎 Тесты поиска
```

### Автор: a-primako

### GitHub: [Aleksandra Primako](https://github.com/a-primako)