package com.example.gebeya_mood.framework.util;

import androidx.annotation.NonNull;

import com.example.gebeya_mood.AppIntroduction.IntroScreenItem;
import com.example.gebeya_mood.R;

import java.util.ArrayList;
import java.util.List;

public final class Const {
    public static final String PREFS_NAME = "GEBEYA_MOOD_PREFS";
    public static final String DATABASE_NAME = "GebeyaMoodDataBase";
    public static final String SEEN_INTRO = "SEEN_INTRO";
    public static final String BASE_URL = "http://gebeya-mood.et5el.gebeya.co ";
    public static final String BASE_URL_HEROKU = "https://stark-peak-15799.herokuapp.com/";
    public static final String SEEN_OAUTH = "SEEN_OAUTH";
    public static final String SEEN_SIGNUP = "SEEN_SIGNUP";
    public static final String SEEN_LOGIN = "SEEN_LOGIN";
    public static final List<String> GENDER = new ArrayList<>();
    public static final List<String> TEAMNAME = new ArrayList<>();

    public static String TEAMNAMEOFDETAIL = "TEAMNAME";
    public static String TEAMNAMEDEPICTGRAPH = "TEAMNAMEDEPICTGRAPH";
    public static String GENERALTEAMMOOD = "GENERALTEAMMOOD";
    public static String GENERALGEBEYAMOOD = "GENERALGEBEYAMOOD";

    @NonNull
    public static String TOKEN = "NO_TOKEN";

    @NonNull
    public static String ROLE = "NO_ROLE";

    @NonNull
    public static String USERNAME = "NO_USER";

    @NonNull
    public static String USER_ID = "NO_USER_ID";
    @NonNull
    public static String USER_EMAIL = "NO_USER_EMAIL";

    @NonNull
    public static String TEAM = "NO_TEAM";

    public static final List<String> Gender (){
        GENDER.add("Female");
        GENDER.add("Male");
        return GENDER;
    }

    public static final List<String> TeamName(){
        TEAMNAME.add("Staff");
        TEAMNAME.add("Talent");
        TEAMNAME.add("Trainer");
        TEAMNAME.add("Trainee");
        TEAMNAME.add("Contractor");
        return TEAMNAME;
    }

    public static final List<IntroScreenItem> IntroContent(){
        List<IntroScreenItem> screens = new ArrayList<>();
        screens.add(new IntroScreenItem("Gebeaya Mood®", "Made for and by Gebeya Inc®. At Gebeya, we all are in the same team. We care about how you feel about everything in Gebeya Inc. Feel free to share your moods.", R.drawable.ic_undraw_winners_ao2o));
        screens.add(new IntroScreenItem("Hi! You're Welcome", "We will check on you to see how you are feeling. Here We will record you emotions so that you can remember your moods a while ago.", R.drawable.ic_undraw_smiley_face_lmgm));
        screens.add(new IntroScreenItem("Gebeya's General Mood", "In the common screen you can see your colleagues teams mood. Feel free to share your moods. At Gebeya we are in the same team. ", R.drawable.ic_undraw_celebration_0jvk));
        screens.add(new IntroScreenItem("Team mood", "In the common screen you can see your colleagues teams mood.Feel free to share your moods. At Gebeya we are in the same team. ", R.drawable.ic_undraw_welcoming_xvuq));
        screens.add(new IntroScreenItem("Happy Company", "Feel free to share your moods. At Gebeya, we all are in the same team. Made for and by Gebeya Inc® ", R.drawable.gebeya_logo_primary));
        return screens;
    }
}
