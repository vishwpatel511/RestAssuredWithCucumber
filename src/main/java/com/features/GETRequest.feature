Feature: Testing the Github APIs using GET call

@get @getAllRepo @positive
Scenario Outline: Getting the all the repos from Github

Given Github APIs are operational
When "<password>" and cookies are passed
And "uri_goes_here" is pass as URI with the necassary "params" as params and "/users/vishwpatel511/repos" as endpoint and GET request is made
Then Response is sent back by server
And Status code should be "<statuscode>"
And repo namely "Page_Object_Model-with-Cucumber" should be present

Examples: 
|password|statuscode|
|Actualpassword|200|

