Feature: Delete Incident Flow
Background: 
Given Launch ServiceNow application with url as "https://dev135016.service-now.com"
And Login username as "admin" 
And Enter password as "Service@123"
And Click All
And Click Incidents in Filter navigator

Scenario: Deletion of an Incident
And Select the Incident to be deleted
And Delete button is clicked
And system asks for confirmation
When check for the deleted incident
Then No records to display should be displayed
And Close the browser
