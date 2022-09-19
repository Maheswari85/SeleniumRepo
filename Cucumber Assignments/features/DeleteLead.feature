Feature: Create a Delete flow


Background:
Given Chrome browser is opened
And Load the application url as "http://leaftaps.com/opentaps/"
And Maximize and set the timeouts
And Enter Username as "DemoSalesManager"
And Enter Password as "crmsfa"
And click Login Button
And Click on CRMSFA link 

Scenario: TC003 Delete a Lead
And Click on Leads Tab
And click on Find Leads Tab
And click on Phone Tab
And Enter Phone number in the phone number field
And click on Find Lead button
And Get the Lead ID for the first search result
And Click on the first Lead ID in the result
And click on Delete option
And Click on Find Lead Tab
And Input the LeadID that was deleted
When click on Find Lead
Then Get the message displayed
And Close Browser
