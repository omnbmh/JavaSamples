package org.github.omnbmh.hprose.examples.server;

import org.github.omnbmh.hprose.examples.entry.Sex;
import org.github.omnbmh.hprose.examples.entry.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Exam2 extends Exam1{
    public Exam2(){
        id = "Exam2";
    }

    public List<User> getUserList() {
        ArrayList<User> userlist = new ArrayList<User>();
        userlist.add(new User("Amy", 26, Date.valueOf("1983-12-03"),  true,Sex.InterSex));
        userlist.add(new User("Bob",20, Date.valueOf("1989-06-12"), false,Sex.Female));
        userlist.add(new User("Chris",29,  Date.valueOf("1980-03-08"),  true,Sex.Male));
        userlist.add(new User("Alex",17 , Date.valueOf("1992-06-14"), false,Sex.Unkown));
        return userlist;
    }
}
