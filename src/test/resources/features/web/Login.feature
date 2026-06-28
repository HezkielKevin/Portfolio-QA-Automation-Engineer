@web
Feature: Autentikasi User (Login)

  @positive
  Scenario Outline: Login sukses pakai akun yang valid (Positive)
    Given saya membuka halaman login
    When saya memasukkan username "<username>"
    And saya memasukkan password "<password>"
    And saya klik tombol login
    Then saya berhasil login dan melihat dashboard

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @negative
  Scenario Outline: Login ditolak karena username/password salah atau kosong (Negative)
    Given saya membuka halaman login
    When saya memasukkan username "<username>"
    And saya memasukkan password "<password>"
    And saya klik tombol login
    Then saya melihat pesan error "<error_message>"

    Examples:
      | username        | password     | error_message                                                             |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      | wrong_user      | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |