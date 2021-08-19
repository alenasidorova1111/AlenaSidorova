Feature: Select elements on Different Elements page

  Scenario Outline: Select elements on Different Elements page
    Given I open Home page
    And I perform login
    And I navigate to Different Elements page through header menu
    When I choose '<force1>' force1 and '<force2>' force2
    And I choose '<metal>' metal
    And I choose '<color>' color
    Then For every chosen item there is a log row

    Examples:
      | force1 | force2 | metal | color  |
      | Water  | Wind   | Selen | Yellow |
