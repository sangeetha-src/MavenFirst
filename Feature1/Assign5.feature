Feature: Test JpetStore application.
Scenario: Test Login with valid credentials
Given Open chrome and navigate to Jpetstore application
When I enter valid Username aNd password
|Field|values|
|username|j2ee|
|password|j2ee|
Then I can able to login successfully

Scenario: Adding Item1 to cart
Given Open chrome and navigate to Jpetstore application
When I enter valid Username aNd password
|Field|values|
|username|j2ee|
|password|j2ee|
When I put Large AngelFish with Item ID EST-1 in my cart
And I further proceed to checkout and confirm the item
Then My Order has been submitted successfully

Scenario: Adding Item2(Bird) To cart
Given Open chrome and navigate to Jpetstore application
When I enter valid Username aNd password
|Field|values|
|username|j2ee|
|password|j2ee|
When Selecting Amazon Parrot with item id EST-18 and add to cart
And I further proceed to checkout and confirm the item
Then My Order has been submitted successfully
