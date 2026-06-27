# Automation Test Framework

Proyek ini adalah framework automation testing terpadu yang dirancang untuk menguji aplikasi Web UI dan API dalam satu repositori. Framework ini menggunakan arsitektur Page Object Model (POM) untuk Web UI dan memisahkan struktur kode untuk menjaga keterbacaan, skalabilitas, dan kemudahan pemeliharaan.

### Struktur Proyek

Framework ini memisahkan skenario pengujian dan kode implementasi untuk Web UI dan API:

- **Features**: Skenario ditulis dalam format Gherkin (`.feature`) dan dipisahkan menjadi folder `web` dan `api` di dalam `src/test/resources/features/`.
- **Step Definitions**: Implementasi langkah-langkah Cucumber berada di paket `org.kevin.steps.web` dan `org.kevin.steps.api`.
- **Page Objects**: Elemen dan interaksi UI untuk pengujian Web dikelola dalam paket `org.kevin.pages` (Page Object Model).
- **Runners**: Konfigurasi eksekusi pengujian ada di `org.kevin.runners`.

### Teknologi dan Pustaka

Berikut adalah alat dan pustaka utama yang digunakan dalam pengembangan framework ini:

- **Bahasa Pemrograman**: Java 17
- **Build Tool**: Gradle
- **Testing Framework**: JUnit 5 (JUnit Platform)
- **BDD Framework**: Cucumber
- **Web UI Automation**: Selenium WebDriver & WebDriverManager
- **API Automation**: REST-assured
- **Pelaporan (Reporting)**: Cucumber Reporting (HTML/JSON) & Masterthought Report

### Cara Menjalankan Pengujian

Proyek ini telah dikonfigurasi dengan dua custom Gradle tasks untuk memudahkan eksekusi pengujian secara spesifik:

1. **Menjalankan Pengujian API** (Menjalankan semua skenario dengan tag `@api`):
   ```bash
   ./gradlew runApiTests
   ```

2. **Menjalankan Pengujian Web UI** (Menjalankan semua skenario dengan tag `@web`):
   ```bash
   ./gradlew runWebTests
   ```

3. **Menghasilkan Laporan (HTML)**:
   ```bash
   ./gradlew generateCucumberReport
   ```
   Laporan dapat diakses pada direktori `build/cucumber-report/html/cucumber-html-reports/overview-features.html`.

### Continuous Integration (CI)

Proyek ini dilengkapi dengan **GitHub Actions Workflow**. Pengujian akan dijalankan secara otomatis saat terjadi _Pull Request_ atau _Push_ ke branch utama. Workflow ini juga dapat dijalankan secara manual (_Workflow Dispatch_). Hasil pelaporan otomatis diunggah sebagai artifacts pada setiap akhir run.

---

# Automation Test Framework

This project is a unified automation testing framework designed to test both Web UI and API applications within a single repository. The framework employs the Page Object Model (POM) architecture for Web UI and separates code structures to maintain readability, scalability, and ease of maintenance.

### Project Structure

The framework separates test scenarios and implementation code for Web UI and API:

- **Features**: Scenarios are written in Gherkin format (`.feature`) and separated into `web` and `api` folders under `src/test/resources/features/`.
- **Step Definitions**: Cucumber step implementations are located in `org.kevin.steps.web` and `org.kevin.steps.api` packages.
- **Page Objects**: UI elements and interactions for Web testing are managed in the `org.kevin.pages` package (Page Object Model).
- **Runners**: Test execution configurations are located in `org.kevin.runners`.

### Technologies and Libraries

The following are the core tools and libraries used in developing this framework:

- **Programming Language**: Java 17
- **Build Tool**: Gradle
- **Testing Framework**: JUnit 5 (JUnit Platform)
- **BDD Framework**: Cucumber
- **Web UI Automation**: Selenium WebDriver & WebDriverManager
- **API Automation**: REST-assured
- **Reporting**: Cucumber Reporting (HTML/JSON) & Masterthought Report

### How to Run Tests

This project is configured with two custom Gradle tasks to facilitate specific test executions:

1. **Run API Tests** (Executes all scenarios tagged with `@api`):
   ```bash
   ./gradlew runApiTests
   ```

2. **Run Web UI Tests** (Executes all scenarios tagged with `@web`):
   ```bash
   ./gradlew runWebTests
   ```

3. **Generate Reports (HTML)**:
   ```bash
   ./gradlew generateCucumberReport
   ```
   Reports can be accessed in the `build/cucumber-report/html/cucumber-html-reports/overview-features.html` directory.

### Continuous Integration (CI)

This project includes a **GitHub Actions Workflow**. Tests are executed automatically upon a _Pull Request_ or _Push_ to the main branch. This workflow can also be triggered manually (_Workflow Dispatch_). The reporting results are automatically uploaded as artifacts at the end of every run.
