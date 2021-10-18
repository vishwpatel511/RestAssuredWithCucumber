Feature: Testing the Github APIs using DELETE call

@deleterepo
Scenario Outline: Deleting a repo from Github

Given Github APIs are operational to perform actions
When "auth" and cookies are passed for DELETE request
And "https://api.github.com" is pass as URI with the necassary "/repos/vishwpatel511/" as params and "<repos>" as a repo to delete and DELETE request is made
Then Response would be sent back by server
And Status code should be 204 for DELETE request

Examples: 
|repos|
|deletedrepo|
|Number954|
|Number396|
|RepositoryCreated-usingGITHUB_API|