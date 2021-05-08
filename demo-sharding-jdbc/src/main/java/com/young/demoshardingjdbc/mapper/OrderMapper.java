package com.young.demoshardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.demoshardingjdbc.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
