package com.it;
import com.it.IUserDao;
import com.it.UserDao;
import com.it.UserDaoProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyModeTest {
    @Test
    public void StaticProxyTest() {


            IUserDao udp=new UserDaoProxy();
            udp.save();
            System.out.println("-------------------");
            udp.find();
    }

    @Test
    public void DynamicProxyTest(){
        //被代理类的实例
        final UserDao ud = new UserDao();

        IUserDao iud = (IUserDao) Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub

                        Object result = null;
                        if ("find".equals(method.getName())) {
                            result = method.invoke(ud, args);
                        } else {
                            System.out.println("开始JDK代理");
                            result = method.invoke(ud, args);
                            System.out.println("结束JDK代理");
                        }

                        return result;
                    }
                });
        //使用代理类调用方法
        iud.find();
        System.out.println("----------------");
        iud.save();

    }
    @Test
    public void cglibProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new MyMethodInterceptor());
        //生成代理类
        UserDao ud=(UserDao) enhancer.create();
        ud.save();
        System.out.println("----------------");
        ud.find();
    }


}
