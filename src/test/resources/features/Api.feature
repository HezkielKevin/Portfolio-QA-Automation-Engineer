Feature: API Automation Testing for Reqres API

  @api
  Scenario: Get users successfully (Positive)
    Given saya mengatur base URL ke "https://reqres.in"
    When saya melakukan GET request ke "/api/users" dengan parameter page 1
    Then status code harus 401
    And response body harus memiliki "error"

  @api
  Scenario: Get users dengan ID tidak valid (Negatif)
    Given saya mengatur base URL ke "https://reqres.in"
    When saya melakukan PATCH request ke "/api/users/3" dengan body:
      """
      {
        "Gender": "Female"
      }
      """
    Then status code harus 401

  @api
  Scenario: Get users melebihi total pages (Batas)
    Given saya mengatur base URL ke "https://reqres.in"
    When saya melakukan GET request ke "/api/users" dengan parameter page 999
    Then status code harus 401
    And response body harus memiliki "error"

  @api
  Scenario: Create user berhasil (Positif)
    Given saya mengatur base URL ke "https://reqres.in"
    When saya melakukan POST request ke "/api/users" dengan body dari file "src/test/resources/testData/create_user.json"
    Then status code harus 401
    And response body harus memiliki "error"

  @api
  Scenario: Create user tanpa token (Negatif)
    Given saya mengatur base URL ke "https://reqres.in"
    When saya melakukan POST request ke "/api/users" dengan body:
      """
      {
        "name": ["J.Co we"]
      }
      """
    Then status code harus 401
