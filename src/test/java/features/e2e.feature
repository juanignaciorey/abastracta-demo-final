Feature: Home, ProductList, CheckOut

  @Test
  Scenario: Search and Add product to the shopping cart and then remove it from it

    Given I am on the Home search page
    When I enter a search iPhone
    And I click search
    And Add the product to the shopping cart
    Then Enter the shopping cart button
    And Press 'View Cart' link
    Then Validate that the selected iPhone is in the shopping cart
    And Remove the iPhone from the shopping cart
    And Validate that the iPhone is no longer in the shopping cart