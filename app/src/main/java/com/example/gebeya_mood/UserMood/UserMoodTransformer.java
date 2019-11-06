package com.example.gebeya_mood.UserMood;

import com.example.gebeya_mood.UserMood.UserMood;
import com.example.gebeya_mood.UserMood.UserMoodGETPojo;

import java.util.ArrayList;
import java.util.List;

public class UserMoodTransformer {

    public static UserMood DtoToMood(UserMoodGETPojo userMoodsDto){

        UserMood userMood = new UserMood(
                userMoodsDto.getId(),
               "",
                "",
                userMoodsDto.getValue(),
                123,
                userMoodsDto.getDateModified(),
                userMoodsDto.getValue());

        return userMood;
    }

    public static List<UserMood> ListDtoToMood(List<UserMoodGETPojo> listMoosDto){
        List<UserMood> userMoods = new ArrayList<UserMood>();
        for(UserMoodGETPojo userMoodsDto : listMoosDto){
            userMoods.add(DtoToMood(userMoodsDto));
        }
        return userMoods;
    }
}
