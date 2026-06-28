@api
Feature: API Security Testing (ReqRes)

  @negative
  Scenario: Broken Authentication - Login tanpa password (Negative)
    When saya mengirimkan request POST ke "/login" dengan payload otentikasi rusak
    Then response API harus ditolak karena bad request atau unauthorized

  @negative
  Scenario: SQL Injection pada API Payload (Negative)
    When saya mengirimkan request POST ke "/login" dengan payload SQL Injection
    Then response API harus ditolak karena bad request atau unauthorized
