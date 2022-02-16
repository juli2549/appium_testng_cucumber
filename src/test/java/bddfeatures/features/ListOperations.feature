Feature: List Operations

  Scenario: Create new Shopping List
    Given the user is in the shopping list screen
    When the user create new list
      | list             |
      | My shopping list |
    Then the list created is visible in main screen at bottom of the screen

  Scenario: Delete complete List with items
    Given the user is in the shopping list screen
    When the user create new list
      | list             |
      | My shopping list |
    When he adds the items
      | item        |
      | Apples      |
      | Apricots    |
      | Bananas     |
      | Blueberries |
      | Cantaloupe  |
      | Cherries    |
    When he edits the items adding the quantity
      | item        | quantity |
      | Cherries    | 35       |
      | Bananas     | 1        |
      | Apricots    | 4        |
      | Cantaloupe  | 10       |
      | Blueberries | 5        |
      | Apples      | 2        |
    When he removes two items
      | item        |
      | Cherries    |
      | Apricots    |
    When he checks all the rest of the items
    When he archives the complete list
    When he deletes the archived list
    Then the deleted list will not appear in archived lists
    And the deleted list will not appear in current lists
