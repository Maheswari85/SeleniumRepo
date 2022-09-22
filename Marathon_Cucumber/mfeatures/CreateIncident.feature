Feature: Create Incident Flow
Background:
Given Launch ServiceNow application with url as "https://dev135016.service-now.com"
And Login username as "admin" 
And Enter password as "Service@123"
And Click All
And Click Incidents in Filter navigator

Scenario: Create new Incident with mandatory fields filled
And Click on Create new option and fill the mandatory fields
When Submit button is clicked
Then New Incident should be available for search
And Confirm incident exists
And Close the browser
