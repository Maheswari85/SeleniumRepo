Feature: Create Lead flow
Background:
Given Chrome browser is opened
And Load the application url as "http://leaftaps.com/opentaps/"
And Maximize and set the timeouts
And Enter Username as "DemoSalesManager"
And Enter Password as "crmsfa" 
And click Login Button
And Click on CRMSFA link
And Click on Leads Tab
And Click on Create Lead

Scenario Outline: TC001 Create Lead with Mandatory Fields filled
 
And Enter Company Name as <companyName>
And Enter  Forename as <foreName>
And Enter Surname as <surName>
When Create button is clicked
Then View Lead page is displayed
And Close Browser

Examples:
|companyName|foreName|surName|
|'Harshad Solutions'|'Harshad'|'Kannan'|
|'KMH Farms'|'Maheswari'|'Kannan'|
|'Kannan Ltd'|'Kannan'|'Simman'|

Scenario: TC002 Create Lead with Mandatory Fields missing
 And Enter Company Name as ""
And Enter  Forename as "Kannan"
And Enter Surname as "Simman"
When Create button is clicked
Then Error message is displayed
And Close Browser
