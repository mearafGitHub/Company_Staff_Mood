package com.example.gebeya_mood.repo.user_moods_repo;

import com.example.gebeya_mood.models.Mood;

import java.util.ArrayList;
import java.util.List;

public class UserMoodTransformer {

    public static Mood DtoToMood(UserMoodsDto userMoodsDto){

        Mood mood = new Mood();
        mood.moodId = userMoodsDto.getMoodId();
        mood.userId = userMoodsDto.getUserId();
        mood.date = userMoodsDto.getDate();
        mood.emotion = userMoodsDto.getEmotion();
        mood.reason = userMoodsDto.getReason();

        return mood;
    }


    public static List<Mood> ListDtoToMood(List<UserMoodsDto> listMoosDto){

        List<Mood> moods = new ArrayList<Mood>();

        for(UserMoodsDto userMoodsDto : listMoosDto){

            moods.add(DtoToMood(userMoodsDto));
        }

        return moods;
    }
}
