package com.example.restfulapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserReq {
    private String name;
    private boolean maleGender;
    private String email;
    private String phone;
    private String avatar;
    private String password;
}
