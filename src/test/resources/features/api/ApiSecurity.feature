@api
Feature: Security Testing API

  @negative
  Scenario: Bypass API tanpa mencantumkan password (Negative)
    When saya mengirimkan request POST ke "/login" dengan payload otentikasi rusak
    Then response API harus ditolak karena bad request atau unauthorized

  @negative
  Scenario: Test penetrasi API pakai payload SQL Injection (Negative)
    When saya mengirimkan request POST ke "/login" dengan payload SQL Injection
    Then response API harus ditolak karena bad request atau unauthorized
