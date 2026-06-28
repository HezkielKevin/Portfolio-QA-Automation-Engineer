@web
Feature: Security Testing Web UI

  @negative
  Scenario: Test penetrasi form login pakai SQL Injection (Negative)
    Given saya membuka halaman login
    When saya memasukkan username "' OR 1=1 --"
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login
    Then saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  @negative @ignore
  Scenario: Test serangan XSS di form checkout (Negative)
    Given saya membuka halaman login
    When saya memasukkan username "standard_user"
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login
    And saya menambahkan produk ke-1 ke dalam keranjang
    And saya menuju halaman keranjang
    And saya klik tombol checkout
    And saya memasukkan First Name "<script>alert(1)</script>"
    And saya memasukkan Last Name "Doe"
    And saya memasukkan Zip Code "12345"
    And saya klik tombol continue
    Then saya berada di halaman konfirmasi pesanan

  @negative
  Scenario: Test serangan XSS di kolom input form login (Negative)
    Given saya membuka halaman login
    When saya memasukkan username "<script>alert(1)</script>"
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login
    Then saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  @negative
  Scenario: Test tembak link halaman inventory tanpa login terlebih dahulu (Negative)
    Given saya mencoba mengakses halaman inventory secara langsung
    Then saya harus dialihkan kembali ke halaman login dengan pesan error "Epic sadface: You can only access '/inventory.html' when you are logged in."
