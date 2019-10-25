package com.example.gebeya_mood.data.moodsData;

import java.util.ArrayList;
import java.util.List;

public class MoodTransformer {

    public static Mood DtoToMood(MoodsDto moodsDto){

        Mood mood = new Mood();
        mood.moodId = moodsDto.getMoodId();
        mood.userId = moodsDto.getUserId();
        mood.date = moodsDto.getDate();
        mood.emotion = moodsDto.getEmotion();
        mood.reason = moodsDto.getReason();

        return mood;
    }


    public List<Mood> ListDtoToMood(List<MoodsDto> listMoosDto){

        List<Mood> moods = new ArrayList<Mood>();

        for(MoodsDto moodsDto : listMoosDto){

            moods.add(DtoToMood(moodsDto));
        }

        return moods;
    }
}
