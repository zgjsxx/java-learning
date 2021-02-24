package com.it;

public class UserDaoProxy implements IUserDao {

    private UserDao ud = new UserDao();

    @Override
    public void save() {
        // TODO Auto-generated method stub

        System.out.println("代理操作，开启事务");
        ud.save();
        System.out.println("代理操作，关闭事务");
    }

    @Override
    public void find() {
        // TODO Auto-generated method stub
        System.out.println("代理操作，开启事务");
        ud.find();
        System.out.println("代理操作，关闭事务");
    }
}
