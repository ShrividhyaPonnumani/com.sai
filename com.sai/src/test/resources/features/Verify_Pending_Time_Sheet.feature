@timesheets
Feature: This feature is to get pending timesheet
Scenario: This test is to verify the pending timesheet
Given the user is on homepage
And the user clicks on time option from the menu
And the user enters the name as "John Smith"
And clicks on the view button
Then the user should see the message as "Actions Performed on the Timesheet"