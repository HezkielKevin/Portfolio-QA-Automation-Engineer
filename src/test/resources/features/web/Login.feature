@web
Feature: Login ke Swag Labs

  Scenario: Login berhasil dengan credential valid (Positif)
    Given saya membuka halaman login
    When saya memasukkan username "standard_user"
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login
    Then saya berhasil login dan melihat dashboard

  Scenario: Login gagal dengan password salah (Negatif)
    Given saya membuka halaman login
    When saya memasukkan username "standard_user"
    And saya memasukkan password "wrong_password"
    And saya klik tombol login
    Then saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login gagal dengan username kosong (Batas)
    Given saya membuka halaman login
    When saya memasukkan username ""
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login
    Then saya melihat pesan error "Epic sadface: Username is required"

  Scenario: Login gagal dengan username sangat panjang (Batas)
    Given saya membuka halaman login
    When saya memasukkan username yang sangat panjang
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login
    Then saya melihat pesan error "Epic sadface: Username and password do not match any user in this service"