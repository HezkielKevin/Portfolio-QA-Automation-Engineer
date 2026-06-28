Feature: Uji Fungsionalitas API

  @api
  Scenario: Berhasil tarik data user dari API (Positive)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan GET request ke "/users" dengan parameter page 1
    Then status code harus 200
    And response body "page" harus 1
    And response body "data.size()" harus 6
    And response body "data[0].email" harus "george.bluth@reqres.in"

  @api
  Scenario: Gagal tarik data user karena ID tidak valid (Negative)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan PATCH request ke "/users3" dengan body:
      """
      {
        "Gender": "Female"
      }
      """
    Then status code harus 404

  @api
  Scenario: Tarik data di luar batas halaman maksimal (Negative)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan GET request ke "/users" dengan parameter page 999
    Then status code harus 200
    And response body "data.size()" harus 0

  @api
  Scenario: Berhasil membuat user baru (Positive)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan POST request ke "/users" dengan body dari file "src/test/resources/testData/create_user.json"
    Then status code harus 201
    And response body "name" harus "Rudi Tabuti"
    And response body "id" tidak boleh kosong
    And response body "createdAt" tidak boleh kosong

  @api
  Scenario: Proses ditolak saat pembuatan user baru dengan token kosong (Negative)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan POST request ke "/users" dengan body:
      """
      {
        "name": ["J.Co we"]
      }
      """
    Then status code harus 401
