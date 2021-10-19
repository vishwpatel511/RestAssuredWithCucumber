Feature: testing Github APIs 

Scenario: updating a repo which is already created

Given Github APIs are operational
When "auth_token" and "cookies" cookies are passed
And "update-payload" is prepared to update a repo
And "url-goes-here" is passed as URI with the "/repos/vishwpatel511/" and "reponame" is passed as endpoint and PATCH request is made
Then Response is sent back by server
And response code should be 200 for PATCH request