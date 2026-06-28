@web
Feature: Fitur Produk (Swag Labs)

  Background:
    Given saya membuka halaman login
    When saya memasukkan username "standard_user"
    And saya memasukkan password "secret_sauce"
    And saya klik tombol login

  @positive
  Scenario: Product list tampil dengan benar
    Then saya melihat daftar produk tersedia
    And semua produk memiliki nama dan harga
    And semua produk menampilkan gambar dengan benar

  @positive
  Scenario Outline: Mengurutkan produk
    When saya memilih urutan produk berdasarkan "<sort_type>"
    Then produk pertama harus bernama "<expected_first_product>"

    Examples:
      | sort_type           | expected_first_product            |
      | Name (Z to A)       | Test.allTheThings() T-Shirt (Red) |
      | Name (A to Z)       | Sauce Labs Backpack               |
      | Price (low to high) | Sauce Labs Onesie                 |
      | Price (high to low) | Sauce Labs Fleece Jacket          |
