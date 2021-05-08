package com.young.demoshardingjdbc.service;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.demoshardingjdbc.entity.Order;
import com.young.demoshardingjdbc.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowired
    private OrderMapper orderMapper;

    public void testInsert() {
        for (long i = 1; i <= 20; i++) {
            Order order = Order.builder().build().setUserId(i).setOrderId(i).setRemark(RandomUtil.randomString(20));
            orderMapper.insert(order);
        }
    }

    public void testDelete(){
         orderMapper.delete(null);
    }

    public void testSelect(){
        List<Order> orders = orderMapper.selectList(new LambdaQueryWrapper<Order>().in(Order::getOrderId, 1, 2));
        System.out.println(orders);
    }

}
