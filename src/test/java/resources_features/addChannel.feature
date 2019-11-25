@addChannel
Feature: Creating a channel and adding a user to it

  @addChannel
  Scenario: Creating a channel and adding a user to it

    When Opening and setting the browser
    When User go to "https://app.slack.com/"
    And Click on the button which contains data-qa "'link_sign_in_nav'"
    And User fill field which contains data-qa "'signin_domain_input'" using text "testgxb"
    And Click on the green span which contains id "'submit_team_domain'"
    And User fill field which contains placeholder "'you@example.com'" using text "testgxb@gmail.com"
    And User fill field which contains placeholder "'password'" using text "Test2289"
    And Click on the green span which contains id "'signin_btn'"
    And Click on the button which contains data-qa "'channel_sidebar__plus__channels'"
    And User fill field which contains data-qa "'channel-name-input'" using text "channelForTest"
    And Click on the button which contains data-qa "'channel_create_modal_cta'"
    And User fill field which contains data-qa "'invite_to_workspace_select-input'" using text "testgxb1"
    And Click to add user from the list
    And Click on the button which contains data-qa "'invite_to_workspace_submit_button'"
    And Waiting "3" seconds

  @delChannel
  Scenario: Dell channel
    And Click on the button which contains data-qa "'channel_header_settings_button'"
    And Click on the section channel header settings "'Additional options…'"
    And Click button which contains data-action "'delete'"
    And Select checkbox by id "'delete_channel_cb'"
    And Click on the button which contains data-qa "'create_action'"
    And Close browser







