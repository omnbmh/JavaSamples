package org.github.omnbmh.hprose.examples.entry;

import java.util.Date;

public class User implements  java.io.Serializable{
    private String name;
    private int age;
    private Date birthday;
    private boolean married;
    private Sex sex;

    public User() {
    }

    public User(String name, int age, Date birthday, boolean married,Sex sex) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.married = married;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
