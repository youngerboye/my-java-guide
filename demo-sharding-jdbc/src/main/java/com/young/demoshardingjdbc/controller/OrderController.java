package com.young.demoshardingjdbc.controller;

import com.young.demoshardingjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="save")
    public void save(){
        orderService.testInsert();
    }

    @GetMapping(value="delete")
    public void delete(){
        orderService.testDelete();
    }

    @GetMapping(value="select")
    public void select(){
        orderService.testSelect();
    }
}
