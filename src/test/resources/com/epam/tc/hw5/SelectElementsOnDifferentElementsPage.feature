Feature: Select elements on Different Elements page

  Scenario: Select elements on Different Elements page
    Given I open Home page
    And I perform login
    And I navigate to Different Elements page
    When I choose elements '1, 2, 3'
    And I choose color '1'
    Then For every chosen element and color there is a log row
    And a value in a log row is corresponded to the selected value


