Feature:

  Background:
    Given user already login

  Scenario: Verify that the user can add to cart one or more products
    When user clicks add to cart button on product page
    |HUMMEL Sneakers White Flat|
    |Olcay Winterjacket Black Puffer|
    And user clicks my cart icon
    Then user should see added product on My cart page

  Scenario: Verify that users can add products to the wishlist(favorites)
    When user clicks add to favorites button on product page
      |HUMMEL Sneakers White Flat|
      |Olcay Winterjacket Black Puffer|
    And user clicks my favorites icon
    Then user should see added product on My favorites page

  Scenario: Verify that the user can successfully buy more than one product that was added to his/her cart
    When user clicks add to cart button on product page
      |HUMMEL Sneakers White Flat|
      |Olcay Winterjacket Black Puffer|
    And user clicks my cart icon
    And user clicks checkout button
    And user clicks order button by paypal
    Then user should see paypal app



