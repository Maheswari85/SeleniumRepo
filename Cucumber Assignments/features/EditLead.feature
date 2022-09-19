Feature: Create Edit flow
Background:
Given Chrome browser is opened
And Load the application url as "http://leaftaps.com/opentaps/"
And Maximize and set the timeouts
And Enter Username as "DemoSalesManager"
And Enter Password as "crmsfa" 
And click Login Button
And Click on CRMSFA link
And Click on Leads Tab
And click on Find Leads Tab

Scenario Outline: Edit company Name in the created Leads
And click on Phone Tab
And Enter Phone number in the phone number field
And click on Find Lead button
And Click on the first Lead ID in the result
And click on Edit Lead
And Update the companyName as <CompanyName>
When Click on Update Button
Then View Lead page is displayed
And Close Browser
Examples:
|CompanyName|
|'Disney Land'|
|'Walt Disney Productions'|
 