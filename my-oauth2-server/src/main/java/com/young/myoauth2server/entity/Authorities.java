package com.young.myoauth2server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: yangzhengwu
 * @date: 2021/5/7
 * @description:
 */
@Data
@TableName("authorities")
public class Authorities {

    private String username;

    private String authority;
}
