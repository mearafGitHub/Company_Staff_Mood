package com.example.gebeya_mood.users;

import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    public static User DtoToUser(UserResponse userDto){
        User user = new User();
        user.userId = userDto.getId();
        user.teamname = userDto.getTeam();
        user.username = userDto.getName();
        user.gender = userDto.getSex();
        user.role = userDto.getSex();
        return user;
    }

    public static List<User> ListDtoToUserList(List<UserResponse> listUsersDto){
        List<User> users = new ArrayList<User>();
        for(UserResponse userDto : listUsersDto){
            users.add(DtoToUser(userDto));
        }
        return users;
    }
}
