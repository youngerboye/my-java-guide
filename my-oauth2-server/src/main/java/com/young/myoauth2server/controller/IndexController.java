package com.young.myoauth2server.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yang zheng wu
 * @date: 2021/5/7
 * @description:
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return SecurityContextHolder.getContext().getAuthentication().getName()+ "登录成功";
    }
}
