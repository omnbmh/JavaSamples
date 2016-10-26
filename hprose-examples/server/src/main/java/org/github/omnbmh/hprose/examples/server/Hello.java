package org.github.omnbmh.hprose.examples.server;


import org.github.omnbmh.hprose.examples.entry.User;

public class Hello {
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }

    public User getUser(User user) {
        user.setName(user.getName() + " from server");
        return user;
    }
}
