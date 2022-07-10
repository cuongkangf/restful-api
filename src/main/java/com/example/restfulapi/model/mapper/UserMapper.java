package com.example.restfulapi.model.mapper;

import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.model.entity.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {

        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setGender(user.isMaleGender()?"male":"female");
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        return tmp;
    }
}
