package com.example.gebeya_mood.Auths;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private String team;

    public LoggedInUser(String userId, String displayName, String team) {
        this.userId = userId;
        this.displayName = displayName;
        this.team = team;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTeamName() {
        return team;
    }
}
