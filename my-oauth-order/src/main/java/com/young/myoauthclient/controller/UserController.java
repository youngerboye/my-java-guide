package com.young.myoauthclient.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PreAuthorize("hasAuthority('user::list')")
    @GetMapping("/list")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @PreAuthorize("hasAuthority('user::add')")
    @GetMapping("/add")
    public Object addUser() {
        return "添加成功";
    }

}
