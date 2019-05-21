package com.gitee.cobra.spring.service;

import com.gitee.cobra.spring.annotation.CobraService;

@CobraService
public class UserService implements IUserService {
    @Override
    public String welcome(String name) {
        return "welcome " + name;
    }
}
