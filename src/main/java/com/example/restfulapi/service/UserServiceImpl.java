package com.example.restfulapi.service;

import com.example.restfulapi.exception.DublicatedException;
import com.example.restfulapi.exception.NotFoundException;
import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.model.entity.User;
import com.example.restfulapi.model.mapper.UserMapper;
import com.example.restfulapi.model.request.CreateUserReq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * UserServiceImpl
 */
@Component
public class UserServiceImpl implements UserService {

        private static ArrayList<User> users = new ArrayList<>();

        static {
                users.add(new User(1, "Pham Viet Cuong", true, "vietcuong@gmail.com", "0918273645",
                                "http://vietcuong_avatar.jpg", "vietcuong"));
                users.add(new User(2, "Pham Hong Duyen", false, "hongduyen@gmail.com", "0987654321",
                                "http://hongduyen_avatar.jpg", "hongduyen"));
                users.add(new User(3, "Le Hai Long", true, "hailong@gmail.com", "0123456789",
                                "http://hailong_avatar.jpg", "hailong"));
                users.add(new User(4, "Truong Van Khanh", true, "vankhanh@gmail.com", "0135792468",
                                "http://vankhanh_avatar.jpg", "vankhanh"));
                users.add(new User(5, "Le Duc Dung", true, "ducdung@gmail.com", "0246812579",
                                "http://ducdung_avatar.jpg", "ducdung"));
                users.add(new User(6, "Phung Quang Hung", true, "quanghung@gmail.com", "0123987654",
                                "http://quanghung_avatar.jpg", "quanghung"));
        }

        @Override
        public List<UserDto> getUserList() {
                List<UserDto> dtoList = new ArrayList<>();
                for (User user : users) {
                        dtoList.add(UserMapper.toUserDto(user));
                }
                return dtoList;
        }

        @Override
        public UserDto getUserById(int id) {
                for (User user : users) {
                        if (user.getId() == id) {
                                return UserMapper.toUserDto(user);
                        }
                }
                throw new NotFoundException("No user found!");
        }

        @Override
        public List<UserDto> getUserByInfo(String name, String email) {
                List<UserDto> userDtoList = new ArrayList<>();
                for (User user : users) {
                        if (user.getName().toLowerCase().contains(name.toLowerCase())
                                        && user.getEmail().contains(email.toLowerCase())) {
                                userDtoList.add(UserMapper.toUserDto(user));
                        }
                }
                if (!userDtoList.isEmpty()) {
                        return userDtoList;
                } else {
                        throw new NotFoundException("No user found!");
                }
        }

        @Override
        public UserDto createUser(CreateUserReq req) {
                for (User user : users) {
                        if (user.getEmail().equals(req.getEmail())) {
                                throw new DublicatedException("This email is exist!");
                        }
                        if (user.getPhone().equals(req.getPhone())) {
                                throw new DublicatedException("This phone is exist!");
                        }
                }
                User newUser = new User();
                newUser.setId(users.size() + 1);
                newUser.setName(req.getName());
                newUser.setMaleGender(req.isMaleGender());
                newUser.setEmail(req.getEmail());
                newUser.setPhone(req.getPhone());
                newUser.setAvatar(req.getAvatar());
                newUser.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));
                users.add(newUser);
                return UserMapper.toUserDto(newUser);
        }
}