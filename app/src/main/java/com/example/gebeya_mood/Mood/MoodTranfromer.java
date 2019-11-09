package com.example.gebeya_mood.Mood;

import java.util.ArrayList;
import java.util.List;

public class MoodTranfromer {



    public static Mood toMood(MoodsCountPojo moodsCountPojo){
        Mood mood = new Mood();
        mood.setHappy(moodsCountPojo.getHappy());
        mood.setSad(moodsCountPojo.getSad());
        mood.setContent(moodsCountPojo.getContent());
        mood.setNeutral(moodsCountPojo.getNeutral());
        mood.setAngry(moodsCountPojo.getAngry());
        return mood;
    }

    public static List<Mood> toMoodList(List<MoodsCountPojo> listTeamPojo){
        List<Mood> moodCounts = new ArrayList<Mood>();
        for(MoodsCountPojo singleMoodCountPojo : listTeamPojo){
            moodCounts.add(toMood(singleMoodCountPojo));
        }
        return moodCounts;
    }
}
