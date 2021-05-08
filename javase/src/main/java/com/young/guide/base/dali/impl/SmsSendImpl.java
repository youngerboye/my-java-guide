package main.java.com.young.guide.base.dali.impl;

import main.java.com.young.guide.base.dali.SmsSend;

/**
 * @author: young
 * @date: 2021/2/25
 * 被代理的实现类
 */
public class SmsSendImpl implements SmsSend {
    @Override
    public String send(String msg) {
        System.out.println(msg);
        return msg;
    }
}
