Feature: Edit Incident Flow
Background: 
Given Launch ServiceNow application with url as "https://dev135016.service-now.com"
And Login username as "admin" 
And Enter password as "Service@123"
And Click All
And Click Incidents in Filter navigator

Scenario: Edit an existing Incident
And select an Incident to be edited
And Edit the Status, Short Description,caller and Urgency fields
And Click on update button
When Edited incident is searched
Then Incident with the updated details should be displayed.
And Close the browser