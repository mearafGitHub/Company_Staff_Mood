package com.example.gebeya_mood.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
public class LoggedInUserView {
    private String displayName;
    private String teamName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName, String teamName )  {
        this.teamName = teamName;
        this.displayName = displayName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
