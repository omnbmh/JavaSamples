package com.gitee.cobra.spring.action;

import com.gitee.cobra.spring.annotation.CobraAutowired;
import com.gitee.cobra.spring.annotation.CobraController;
import com.gitee.cobra.spring.annotation.CobraRequestMapping;
import com.gitee.cobra.spring.annotation.CobraRequestParam;
import com.gitee.cobra.spring.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CobraController
@CobraRequestMapping("/user")
public class UserAction {

    @CobraAutowired
    private IUserService userService;


    @CobraRequestMapping("/welcome")
    public void welcome(HttpServletRequest req, HttpServletResponse resp, @CobraRequestParam("name") String name) {
        try {
            resp.getWriter().write(userService.welcome(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
