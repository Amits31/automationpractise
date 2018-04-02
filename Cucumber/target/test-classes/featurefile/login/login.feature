
Feature: Register email ID to application

Scenario: Login to application
Given navigate to application
When user click on sign in link
And enter incorrect email address "amit@"
Then appropriate error message should display "Invalid email address."
When enter correct email address as "amit.shpkr@gmail.com"
And click on create an account




