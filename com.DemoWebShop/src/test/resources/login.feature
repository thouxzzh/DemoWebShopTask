Feature: DemoWebShop Feature
  I want to log in to DemoWebShop and update my address details

  @ValidCredentials
  Scenario: Login with Valid credentials and update address details
    Given the user is on the Home page
    When the user clicks the login link
    And the user provides the valid credentials
      | Email                 | Password  |
      | 2k21dhar@gmail.com    | Dhar@123 |
    And the user clicks the login button
    Then the user should be successfully logged in

    When the user clicks their email address
    And the user clicks the addresses link
    And the user clicks the Add new
    And the user fills in the address details:
      | FirstName | LastName | Email               | Company  | Country | State | City  | Address1 | Address2 | Zip    | Phone number | Fax number |
      | Thoushi      | Francis    | 2k21dhar@gmail.com  | ABC Pvt  | India   | TamilNadu | Chennai | Street 1 | Street 2 | 600001 | 9876543210   | 0441234567 |
    And the user clicks the save button
    Then the details should be saved successfully
