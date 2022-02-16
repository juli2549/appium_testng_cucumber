Feature: Items Operations

  Scenario: Add new Items
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
    Then the created items are displayed



  Scenario: Edit and Delete Items
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
      | Blueberries |
      | Bananas     |
    Then the deleted items will not appear in list