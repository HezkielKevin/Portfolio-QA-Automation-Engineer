@web
Feature: Fitur Keranjang Belanja (Cart)

  Background:
    Given saya membuka halaman login
    When saya memasukkan username "standard_user"
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login

  @positive
  Scenario: Menambah dan menghapus produk dari keranjang
    Given keranjang belanja kosong
    When saya menambahkan produk ke-1 ke dalam keranjang
    Then angka pada badge keranjang harus "1"
    
    When saya menambahkan produk ke-2 ke dalam keranjang
    Then angka pada badge keranjang harus "2"
    
    When saya menuju halaman keranjang
    And saya menghapus produk pertama dari keranjang
    Then angka pada badge keranjang harus "1"
