package org.github.omnbmh.hprose.examples.server;

import org.github.omnbmh.demome.core.service.IUserService;
import org.github.omnbmh.hprose.examples.entry.Sex;
import org.github.omnbmh.hprose.examples.entry.User;
import org.github.omnbmh.hprose.examples.iserver.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

//@Service
public class User implements IUserServer {

    @Autowired
    IUserService userService;

    public int getUserAge(String name) {
        return 1024;
    }

    public User getUser(String name) {
        return new User("Amy", 26, Date.valueOf("1983-12-03"), true, Sex.InterSex);
    }

    public User changeUserName(User user) {
        return new User("Amy", 26, Date.valueOf("1983-12-03"), true, Sex.InterSex);
    }

    public User[] getAllUser() {
        List<org.github.omnbmh.demome.core.entity.User> user = userService.query();

        User[] userlist = new User[user.size()];
        for (int i = 0; i < user.size(); i++) {
            userlist[i] = new User(user.get(i).getUsername(), i, Date.valueOf("1983-12-03"), false, Sex.Unkown);
        }
//        userlist[0] = (new User("Amy", 26, Date.valueOf("1983-12-03"), true, Sex.InterSex));
//        userlist[1] = (new User("Bob", 20, Date.valueOf("1989-06-12"), false, Sex.Female));
//        userlist[2] = (new User("Chris", 29, Date.valueOf("1980-03-08"), true, Sex.Male));
//        userlist[3] = (new User("Alex", 17, Date.valueOf("1992-06-14"), false, Sex.Unkown));
        return userlist;
    }
}
