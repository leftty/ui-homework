Feature: Testing emag website
  As a user that goes to emag website
  I should be able to add and remove products to and from the shopping cart


  Scenario: I should be able to successfully add two products to cart and assert that the operation is successful,
  then subsequently remove successfully one of them and assert that the result is correct,
  then subsequently remove successfully the remaining one and assert that the result is correct
  then subsequently try to remove again one of the products
    Given I go to ecommerce website
    When I search for "xiaomi"
    And I add to cart product 1 from search results page
    And I add to cart product 2 from search results page
    And I go to shopping cart page
    Then I should see 2 products in the shopping cart
    When I remove product 1 from shopping cart
    Then I should see 1 products in the shopping cart
    When I remove product 1 from shopping cart
    Then I should see shopping card is empty
    When I remove product 1 from shopping cart