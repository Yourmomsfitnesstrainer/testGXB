@all
Feature: Creating a channel and adding a user to it

  @all
  Scenario: any scenario


    When User go to "https://app.slack.com/"
    And Click on the button in the top menu which contains text "'Sign in'"
    And User fill field which contains placeholder "'your-workspace-url'" using text "testgxb"
    And Click on the green span which contains text "'Continue'"
    And Waiting "5" seconds
#    And Close browser




