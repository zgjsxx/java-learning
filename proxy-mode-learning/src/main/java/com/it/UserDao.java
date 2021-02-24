package com.it;

public class UserDao implements  IUserDao{

    @Override
    public void save() {
        System.out.println("模拟保存用户");
    }

    @Override
    public void find() {
        System.out.println("模拟查找用户");
    }
}
