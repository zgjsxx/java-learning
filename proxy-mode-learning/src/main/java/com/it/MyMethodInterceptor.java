package com.it;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // TODO Auto-generated method stub

        System.out.println("开始CGLib动态代理");
        Object object=proxy.invokeSuper(obj, args);
        System.out.println("结束CGLib动态代理");
        return object;
    }

}