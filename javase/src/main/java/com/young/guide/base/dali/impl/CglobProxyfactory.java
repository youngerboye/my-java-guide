package main.java.com.young.guide.base.dali.impl;

import main.java.com.young.guide.base.dali.AliSmsService;
import main.java.com.young.guide.base.dali.MyMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author: young
 * @date: 2021/2/25
 * cglib的动态代理
 */
public class CglobProxyfactory {

    public static Object getProxy(Class<?>clazz ){
        //创建胴体代理的增强类
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new MyMethodInterceptor());
        //创建代理类
        return enhancer.create();
    }

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService)
                CglobProxyfactory.getProxy(AliSmsService.class);
        aliSmsService.send("hello");
    }

}
