
Sebelum memulai tugas silahkan tonton dulu video berikut ini: https://drive.google.com/file/d/1jLrqXEr6AnFUAG9qXCyexOwDiYH66RAz/view?usp=drive_link

Instruksi Tugas

Membuat kerangka kerja (framework) untuk menguji tampilan dan fungsi dari sebuah website secara otomatis. Framework ini akan:
Menggunakan Cucumber untuk menulis skenario uji dalam format seperti cerita

Menggunakan Selenium untuk menjalankan tes di browser

Ditulis dalam Java, dikelola menggunakan Gradle


Langkah-Langkah Mengerjakan Tugas:
1. Buat Proyek Gradle
Buat folder proyek baru

Tambahkan build.gradle dengan dependensi berikut:

Cucumber (untuk menjalankan test)

Selenium WebDriver (untuk otomatisasi browser)

JUnit (untuk menjalankan test di Java)

2. Gunakan Page Object Model (POM)
Buat 1 file Java untuk setiap halaman website yang diuji

Di dalam file tersebut, buat fungsi-fungsi untuk klik tombol, isi formulir, dan baca teks dari halaman

Contoh: LoginPage.java → untuk halaman login

Ini membantu agar kode tetap rapi dan mudah dirawat

3. Tulis Test Case dengan Gherkin
Buat file .feature dengan format cerita (Gherkin syntax)

4. Implementasikan Step Definitions
Buat file Java untuk menghubungkan baris di .feature dengan perintah Java/Selenium

Contoh: Baris When saya memasukkan username akan dijalankan dengan kode untuk mengetik di kolom login


5. Buat Tes Positif, Negatif, dan Batas
Positif: login dengan username dan password yang benar

Negatif: login dengan data salah

Batas: coba masukkan username yang sangat panjang, atau kosong

6. Jalankan Tes & Buat Laporan
Jalankan semua test dan pastikan berjalan lancar

Pastikan muncul laporan hasil tes (Cucumber akan membuat laporan otomatis)


Penyerahan Tugas
Buat Repository GitHub

Upload semua file dan folder dari proyekmu

Repositori harus berisi kode sumber untuk framework, implementasi Page Object Model, test case Gherkin, dan implementasi Cucumber.

File README yang tepat yang menjelaskan penerapan kerangka uji UI Web menggunakan Cucumber, Java, Gradle, dan Selenium.

Repositori harus menyertakan kasus uji sampel untuk mendemonstrasikan fungsionalitas dari framework.

Kirimkan Link GitHub

Kirim link ke repository GitHub-mu sebagai hasil akhir tugas dibawah ini. (jika tombol ‘attach link to file’ tidak berfungsi, bisa tuliskan link di kolom ‘additional notes’ dan click next / yes pada notifikasi yang muncul, kemudian klik submit dan jawabanmu akan otomatis terkirim)
