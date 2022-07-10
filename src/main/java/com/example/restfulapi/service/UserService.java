package com.example.restfulapi.service;

import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.model.request.CreateUserReq;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService
 */
@Service
public interface UserService {
    public List<UserDto> getUserList();

    public UserDto getUserById(int id);

    public List<UserDto> getUserByInfo(String name, String email);

    public UserDto createUser(CreateUserReq req);
}