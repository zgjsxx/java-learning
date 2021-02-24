package com.it;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.it.IUserDao;
import com.it.UserDao;
/**
 * *
 *<p>Title: DynamicProxy</p>
 * <p>Description: 动态代理类</p>
 * <p>Company: </p>
 * @author Administrator
 * @date 2019年4月24日 下午4:35:00
 */
public class DynamicProxy implements InvocationHandler {
    //被代理类的实例
    private IUserDao iud = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        Object result = null;
        System.out.println("开始JDK动态代理");
        method.invoke(iud, args);
        System.out.println("结束JDK动态代理");
        return result;
    }

    //构造方法
    public DynamicProxy(IUserDao iud) {
        this.iud = iud;
    }
}
