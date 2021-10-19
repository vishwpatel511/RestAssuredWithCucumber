Feature: Testing the Github APIs using GET call

@get @getAllRepo @positive
Scenario: Getting the all the repos from Github

When "auth_token" and "cookies" cookies are passed
And "uri_goes_here" is pass as URI with the necassary "params" as params and "/users/vishwpatel511/repos" as endpoint and GET request is made
Then Response is sent back by server
And Status code should be 200
And repo namely "repobyframework" should be present


