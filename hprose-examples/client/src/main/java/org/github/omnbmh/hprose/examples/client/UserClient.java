package org.github.omnbmh.hprose.examples.client;

import hprose.client.HproseHttpClient;
import hprose.io.HproseClassManager;
import org.github.omnbmh.hprose.examples.entry.User;
import org.github.omnbmh.hprose.examples.iserver.IUserServer;

import java.io.IOException;


public class UserClient {
    public static void main(String[] args) throws IOException {
        HproseClassManager.register(User.class, "User");
        HproseHttpClient client = new HproseHttpClient();
        client.useService("http://localhost:8080/server/User");
        IUserServer userServer = client.useService(IUserServer.class, "user_s");
        User[] users = userServer.getAllUser();
        for (User user : users) {
            System.out.printf("name: %s, ", user.getName());
            System.out.printf("age: %d, ", user.getAge());
            System.out.printf("sex: %s, ", user.getSex());
            System.out.printf("birthday: %s, ", user.getBirthday());
            System.out.printf("married: %s.", user.isMarried());
            System.out.println();
        }

        System.out.printf("Amy's age: %d",userServer.getUserAge("Amy"));
    }
}
