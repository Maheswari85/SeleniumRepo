Feature: Merge Lead flow
Background:
Given Chrome browser is opened
And Load the application url as "http://leaftaps.com/opentaps/"
And Maximize and set the timeouts
And Enter Username as "DemoSalesManager"
And Enter Password as "crmsfa" 
And click Login Button
And Click on CRMSFA link

Scenario: TS005_MergeLeads
And Click on Leads Tab 
And Click on Merge Leads
And Select From and To Leads from the lookup table
When Merge Button is clicked and Alert Message is accepted
Then View Lead page is displayed
And Close Browser 