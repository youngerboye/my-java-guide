package main.java.com.young.guide.base.dali.impl;

import main.java.com.young.guide.base.dali.SmsSend;

/**
 * @author: young
 * @date: 2021/2/25
 * 实现静态代理，思想就是重新写一个类，将要代理的类写入到构造方法中，
 * 代理类重写接口中的方法，调用被代理的类中的方法
 */
public class SmsProxy implements SmsSend {

    SmsSend smsSend;

    public SmsProxy(SmsSend smsSend) {
        this.smsSend = smsSend;
    }

    @Override
    public String send(String msg) {
        System.out.println("send before");
        smsSend.send(msg);
        System.out.println("send after");
        return msg;
    }

    public static void main(String[] args) {
        SmsSend smsSend = new SmsSendImpl();
        SmsProxy smsProxy = new SmsProxy(smsSend);
        smsProxy.send("java");
    }
}
