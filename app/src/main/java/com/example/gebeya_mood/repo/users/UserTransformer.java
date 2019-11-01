package com.example.gebeya_mood.repo.users;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodsDto;

import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    public static User DtoToUser(UserDto userDto){

        User user = new User();
        user.userId = userDto.getUserId();
        user.team = userDto.getTeam();
        user.userId = userDto.getUserId();
        user.username = userDto.getUsername();
        user.gender = userDto.getGender();

        return user;
    }


    public static List<User> ListDtoToUserList(List<UserDto> listUsersDto){

        List<User> users = new ArrayList<User>();

        for(UserDto userDto : listUsersDto){

            users.add(DtoToUser(userDto));
        }

        return users;
    }
}
