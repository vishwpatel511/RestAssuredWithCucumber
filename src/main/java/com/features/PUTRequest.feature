Feature: testing Github APIs 

Scenario: updating a repo which is already created

Given Github APIs are running and operational
When "auth_token" as a token and "cookies" as a cookies are passed
And "update-payload" is prepared to update a repo
And "https://api.github.com/" is passed as URI with the "repos/vishwpatel511/" and "reponame" is passed as endpoint and PATCH request is made
Then response is received from the server
And response code should be 200 for PATCH request