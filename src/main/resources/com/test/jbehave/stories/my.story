Narrative:
In order to log in into Gmail
As a user
I want to make sure that log in page works as expected

Scenario: Negative test log in page.
Given home google page http://google.com.ua/
And gmail authentication form
When the user has entered wrong test_username and test_password
And log-in button has been pressed
Then the user should see corresponding error message:
|message|
|Введена електронна адреса чи пароль неправильні. ?|

Scenario: Positive test log in page.
Given home google page http://google.com.ua/
And gmail authentication form
When the user has entered wrong olexandr.kara@gmail.com and Oab22uaru91
And log-in button has been pressed
Then the user should transfer to the google search page
And new message on the top of screen should appeared:
|message|
|Заходите на Google проще. Сделайте Google поиском по умолчанию.|