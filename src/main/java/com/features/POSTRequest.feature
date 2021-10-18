Feature: Testing the Github APIs using POST call

@post @postAllRepo
Scenario: creating new the repo on Github

Given Github APIs are operational
When "headers" and cookies are passed
And "https://api.github.com/" is passed as URI with the "vishwpatel511/repos" as endpoint and GET request is made
Then Response is sent back by server
And Status code should be "403"