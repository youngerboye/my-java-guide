package com.young.myoauthclient.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PreAuthorize("hasAuthority('product::list')")
    @GetMapping("/list")
    public Object list() {
        return "小米";
    }

    @PreAuthorize("hasAuthority('product::add')")
    @GetMapping("/add")
    public Object add() {
        return "添加成功";
    }

    @PreAuthorize("hasAuthority('product::update')")
    @GetMapping("/update")
    public Object update() {
        return "更新成功";
    }

    @PreAuthorize("hasAuthority('product::delete')")
    @GetMapping("/delete")
    public Object delete() {
        return "删除成功";
    }
}
