# QA Automation Portfolio: E-Commerce & API Data Validation

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![REST-assured](https://img.shields.io/badge/REST_assured-02303A?style=for-the-badge&logo=json&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)

> A robust, industry-standard automation suite built for high-performance testing. Features include BDD implementation, Page Object Model (POM), cross-endpoint request chaining, and CI/CD integration to simulate real-world e-commerce user journeys and API data management.

## 📖 The Problem (Technical Showcase)

Proyek ini tidak sekadar pengujian otomatis biasa, melainkan simulasi skenario dunia nyata (Technical Showcase) untuk menguji keandalan sistem web dan API.
- **Web UI (SwagLabs):** Mengotomatisasi alur kompleks e-commerce, mencakup "End-to-End User Journey" seperti proses *login*, validasi halaman, hingga penanganan *Negative Testing* (memastikan sistem menolak *login* dengan kredensial tidak valid).
- **API (ReqRes):** Fokus pada "Contract Testing & Data Validation". Memvalidasi operasi manajemen *user* (GET, POST, PATCH), *Happy Path* (status 200/201), dan *Negative Testing* (menangani token atau request yang tidak sah).

## 🚀 The Approach

Untuk memastikan *framework* ini memenuhi standar industri, saya menerapkan pendekatan arsitektur yang terstruktur:

| Komponen | Teknologi | Alasan & Implementasi |
| --- | --- | --- |
| **Framework** | Cucumber + Gherkin | **BDD Approach:** Saya menggunakan BDD untuk menjembatani kesenjangan komunikasi antara kebutuhan bisnis (Product Manager) dan implementasi teknis. *Test cases* menjadi dokumen hidup yang mudah dibaca non-programmer. |
| **Design Pattern** | Page Object Model (POM) | **Modular Architecture:** Setiap halaman website dipisahkan menjadi *object* tersendiri di dalam paket `org.kevin.pages`. Ini secara drastis meningkatkan *reusability* dan mempermudah *maintenance* ketika terjadi perubahan UI tanpa menyentuh *step definitions*. |
| **Automation Tool** | Selenium & REST-assured | **Hybrid Testing:** Saya mengintegrasikan testing UI dan API. Selenium digunakan karena stabilitasnya dalam menangani elemen dinamis, dan REST-assured digunakan untuk mengelola *data setup* serta validasi *backend* secara presisi. |
| **CI/CD** | GitHub Actions | **Automation Pipeline:** Menjalankan *regression test* secara otomatis di setiap *push* atau *pull request*. Ini memastikan bahwa tidak ada fitur yang rusak (*regression*) sebelum kode digabung ke *branch* utama. |

## 📊 The Results & Evidence

Setiap langkah dalam pengujian ini didokumentasikan dan diverifikasi oleh mesin, termasuk **tangkapan layar otomatis (Auto-Screenshot)** setiap kali sebuah langkah Web UI dieksekusi, yang terlampir langsung di dalam laporan.

👉 **[Lihat Live HTML Report & Studi Kasus](https://hezkielkevin.github.io/Portfolio-QA-Automation-Engineer/)**

### Test Coverage Summary:
- **Authentication (Web):** Valid login, invalid credentials, locked user accounts.
- **Data Integrity (API):** Validasi *schema*, respons data, pembuatan data sukses, hingga penolakan operasi tanpa token (401).

---

## 💻 How to Run Locally

Proyek ini telah dikonfigurasi dengan Gradle agar sangat mudah dijalankan.

**1. Menjalankan Pengujian API:**
```bash
./gradlew runApiTests
```

**2. Menjalankan Pengujian Web UI:**
```bash
./gradlew runWebTests
```

**3. Menjalankan Semua Tes:**
```bash
./gradlew test
```
Laporan lengkap akan secara otomatis ter-generate di `build/reports/cucumber/cucumber.html`.
