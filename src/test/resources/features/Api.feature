Feature: API Automation Testing

  @api
  Scenario: Get users successfully (Positive)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan GET request ke "/users" dengan parameter page 1
    Then status code harus 200
    And response body "page" harus 1
    And response body "data.size()" harus 6
    And response body "data[0].email" harus "george.bluth@reqres.in"

  @api
  Scenario: Get users dengan ID tidak valid (Negatif)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan PATCH request ke "/users3" dengan body:
      """
      {
        "Gender": "Female"
      }
      """
    Then status code harus 404

  @api
  Scenario: Get users melebihi total pages (Batas)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan GET request ke "/users" dengan parameter page 999
    Then status code harus 200
    And response body "data.size()" harus 0

  @api
  Scenario: Create user berhasil (Positif)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan POST request ke "/users" dengan body dari file "src/test/resources/testData/create_user.json"
    Then status code harus 201
    And response body "name" harus "Rudi Tabuti"
    And response body "id" tidak boleh kosong
    And response body "createdAt" tidak boleh kosong

  @api
  Scenario: Create user tanpa token (Negatif)
    Given saya mengatur base URL ke "https://reqres.in/api"
    When saya melakukan POST request ke "/users" dengan body:
      """
      {
        "name": ["J.Co we"]
      }
      """
    Then status code harus 401
