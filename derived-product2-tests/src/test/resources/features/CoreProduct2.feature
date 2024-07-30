#Author: sawantkshitij001@gmail.com

@CoreProduct2
Feature: Title of your feature


  @FooterLinks
  Scenario Outline: Verify footer links
	Given User has navigated to the home page "<url>"
	Then scroll down till the bottom of the page
	When different links for various categories are present
	Then find all the hyperlinks for the footer the into a CSV file and report
	And report if any duplicates are present.
	
	Examples:
	|url|
	|https://www.nba.com/bulls/|
	
	
