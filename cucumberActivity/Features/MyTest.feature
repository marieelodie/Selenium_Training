Feature: to test login functionality

Scenario: User tries to login to the demo page
Given I navigate to the login page
When I submit username and password
	|user            			|pass     	 |
	|elodiekatsia@gmail.com     |Elodie2001  |	
Then I should be logged in
