Feature: Testing the Github APIs using GET call

@get @getAllRepo
Scenario: Getting the all the repos from Github

Given Github APIs are operational
When "password" and cookies are passed
And "https://api.github.com" is pass as URI with the necassary "" as params and "/users/vishwpatel511/repos" as endpoint and GET request is made
Then Response is sent back by server
And Status code should be "200"
And repo namely "Page_Object_Model-with-Cucumber" should be present
