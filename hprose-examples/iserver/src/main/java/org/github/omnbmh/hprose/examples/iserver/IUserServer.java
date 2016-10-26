package org.github.omnbmh.hprose.examples.iserver;

import hprose.common.SimpleMode;
import org.github.omnbmh.hprose.examples.entry.User;


public interface IUserServer {
    @SimpleMode(true)
    int getUserAge(String name);

    @SimpleMode()
    User getUser(String name);

    @SimpleMode()
    User changeUserName(User user);

    @SimpleMode()
    User[] getAllUser();
}
