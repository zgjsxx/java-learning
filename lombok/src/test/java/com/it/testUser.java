package com.it;

import com.it.entity.User;
import org.junit.Test;


public class testUser {
    @Test
    public void testUser(){
        User user = new User();
        user.setName("AnyCode");
        user.setAge(20);
        System.err.println(user.toString());
    }
}
