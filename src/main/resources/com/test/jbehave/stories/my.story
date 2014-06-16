Narrative:
In order to log in into Gmail
As a user
I want to make sure that log in page works as expected

Scenario: Test log in page.
Given home google page "http://google.com.ua/"
And gmail authentication form
When the user has entered wrong username and password
And log-in button has been pressed
Then the user should see corresponding error message:
|message|
|Введена електронна адреса чи пароль неправильні|