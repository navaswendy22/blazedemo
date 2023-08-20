Feature: Purchase in demoBlaze

  @test @addProducts
  Scenario: I wants to add three products from several categories
    Given I enters to the "STORE"
    When I want to add three products "Samsung galaxy s6" "MacBook air" "Apple monitor 24"
    And I verify that I added "3" products
    Then I confirm that I have added the products accurately


  @test @deleteProducts
  Scenario: I want to add two products from different categories and ensure their quantities match.
    Given I enters to the "STORE"
    When I want to add three products "Samsung galaxy s6" "MacBook air" "Apple monitor 24"
    But I delete a product "Samsung galaxy s6"
    Then I verify that I added "2" products



  @test @placeOrder
  Scenario Outline: I want to complete the checkout process and ensure that the displayed card number matches.
    Given I enters to the "STORE"
    When I want to add three products "Samsung galaxy s6" "MacBook air" "Apple monitor 24"
    And I proceed to complete the checkout flow with the following information "<Name>" "<Country>" "<City>" "<Credit Card>" "<Month>" "<Year>"


    Examples:
      | Name      | Country    |   City     | Credit Card             |   Month     | Year     |
      | Wendy     | Chile      |  Santiago  | 5100010000000114        |     01      |  25      |
