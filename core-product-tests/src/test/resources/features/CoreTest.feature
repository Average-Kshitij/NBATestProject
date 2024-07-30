#Author: sawantkshitij001@gmail.com
@CoreProduct
Feature: Core product feactures.

  @Jackettest
  Scenario: Check jacket price
    Given User has navigated to the home page URL
    Then close the dialog present on the homepage
    Then move to shop menu and click men's section.
    Then Filter products with Jackets
    And Get price , title and Seller message for all the products

  @Videofeedtest
  Scenario: Check video feed count
  Given User has navigated to the home page URL
  Then close the dialog present on the homepage
  Then hover on the triple dot menu
  And click on the news and features option
  Then count video feeds older than or equal to 3 days old