#Author: sawantkshitij001@gmail.com

@Derivedproduct1
Feature: Derivede product1 feature

  @Validateslides
  Scenario Outline: Validate slides
  Given user has navigated to the home page "<url>"
  Then count number of slids present under ticket menu
  And get title with each slide and valdidate with expected title
  Then Count how much duration each slide is playing
  And validate the time with expected value
  
  Examples:
  |url|
  |https://www.nba.com/sixers/|
