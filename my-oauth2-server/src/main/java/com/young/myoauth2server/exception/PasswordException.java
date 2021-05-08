package com.young.myoauth2server.exception;

/**
 * @author: yang zheng wu
 * @date: 2021/5/7
 * @description:
 */
public class PasswordException extends RuntimeException{

    private Integer code;
    private String desc;

    public PasswordException(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
