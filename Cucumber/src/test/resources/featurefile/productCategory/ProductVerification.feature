@tag
Feature: ProductCategoryPage
@tag1
  Scenario: Verify Products based on price filters
    Given navigate to application page
    When user click on dress navigation menu
    And click on sort by price lowest first filter "Price: Lowest first"
    Then verify product is filtered according to price
