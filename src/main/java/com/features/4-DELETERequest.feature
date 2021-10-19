Feature: Testing the Github APIs using DELETE call

@deleterepo
Scenario: Deleting a repo from Github

Given Github APIs are operational
When "auth_token" and "cookies" cookies are passed
And "url goes here" is pass as URI with the necassary "/repos/vishwpatel511/" as params and "reponame" as a repo to delete and DELETE request is made
And Status code should be 204 for DELETE request
