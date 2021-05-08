package main.java.com.young.guide.base.dali;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method" + method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after method" + method.getName());
        return o1;
    }
}
