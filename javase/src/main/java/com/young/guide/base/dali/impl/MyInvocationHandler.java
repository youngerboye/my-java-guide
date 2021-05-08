package main.java.com.young.guide.base.dali.impl;

import main.java.com.young.guide.base.dali.SmsSend;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: young
 * @date: 2021/2/25
 * jdk的动态代理，主要理念是实现invocationHandler接口，相比于静态代理，用到了反射的机制
 * 但是jdk动态代理还是静态代理，都智能代理有接口的类
 */
public class MyInvocationHandler implements InvocationHandler {

    private SmsSendImpl smsSend;

    public MyInvocationHandler(SmsSendImpl smsSend) {
        this.smsSend = smsSend;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method:" + method.getName());
        Object invoke = method.invoke(smsSend, args);
        System.out.println("after method:" + method.getName());
        return invoke;
    }

    public static void main(String[] args) {
        SmsSend smsSend = (SmsSend)
                Proxy.newProxyInstance(SmsSendImpl.class.getClassLoader(),
                        SmsSendImpl.class.getInterfaces(),
                        new MyInvocationHandler(new SmsSendImpl()));
        smsSend.send("java");


        Lock lock = new ReentrantLock();
    }
}
