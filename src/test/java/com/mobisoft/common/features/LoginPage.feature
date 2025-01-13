Feature: Login Page Test cases

@LoginPage
Scenario: Verify login with invalid credentials
Given User is on saucedemo login page
When User enters username "ABCD" and password "XYZ@143213" and clicks on login page
Then User should not be able to login and get error validation message


@LoginPage
Scenario: Verify login with valid credentials
Given User is on saucedemo login page
When User enters username "standard_user" and password "secret_sauce" and clicks on login page
Then User should be on dashboard page