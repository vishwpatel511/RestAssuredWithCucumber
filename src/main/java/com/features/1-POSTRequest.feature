Feature: Testing the Github APIs using POST call

@post @postAllRepo
Scenario: creating new the repo on Github

Given Github APIs are operational
When "auth_token" and "cookies" cookies are passed
And "payload" is prepared
And "uri_goes_here" is passed as URI with the "/user/repos" as endpoint and POST request is made
Then Response is sent back by server
And Status code should be 201 for post request 