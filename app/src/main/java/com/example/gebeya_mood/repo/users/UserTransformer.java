package com.example.gebeya_mood.repo.users;

import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodsDto;

import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    public static UserMood DtoToMood(UserMoodsDto userMoodsDto){

        UserMood userMood = new UserMood();
        userMood.userId = userMoodsDto.getUserId();
        userMood.user_emotion = userMoodsDto.getMoodId();
        userMood.userId = userMoodsDto.getUserId();
        userMood.date = userMoodsDto.getDate();
        userMood.reason = userMoodsDto.getReason();

        return userMood;
    }


    public static List<UserMood> ListDtoToMood(List<UserMoodsDto> listMoosDto){

        List<UserMood> userMoods = new ArrayList<UserMood>();

        for(UserMoodsDto userMoodsDto : listMoosDto){

            userMoods.add(DtoToMood(userMoodsDto));
        }

        return userMoods;
    }
}
