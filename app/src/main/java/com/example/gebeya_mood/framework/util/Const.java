package com.example.gebeya_mood.framework.util;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public final class Const {
    public static final String PREFS_NAME = "GEBEYA_MOOD_PREFS";
    public static final String DATABASE_NAME = "GebeyaMoodDataBase";
    public static final String SEEN_INTRO = "SEEN_INTRO";
    public static final String BASE_URL = "http://gebeya-mood.et5el.gebeya.co";
    public static final String BASE_URL_HEROKU = "http://gebeya-mood.et5el.gebeya.co";
    public static final String SEEN_OAUTH = "SEEN_OAUTH";
    public static final String SEEN_SIGNUP = "SEEN_SIGNUP";
    public static final String SEEN_LOGIN = "SEEN_LOGIN";
    public static final List<String> GENDER = new ArrayList<>();
    public static final List<String> TEAMNAME = new ArrayList<>();

    @NonNull
    public static String TOKEN = "NO_TOKEN";

    @NonNull
    public static String ROLE = "NO_ROLE";

    @NonNull
    public static String USERNAME = "NO_USER";

    @NonNull
    public static String TEAM = "NO_TEAM";

    public static List<String> Gender (){
        GENDER.add("Female");
        GENDER.add("Male");
        return GENDER;
    }

    public static List<String> TeamName(){
        TEAMNAME.add("Staff");
        TEAMNAME.add("Talent");
        TEAMNAME.add("Trainer");
        TEAMNAME.add("Trainee");
        TEAMNAME.add("Contractor");
        return TEAMNAME;
    }

}
