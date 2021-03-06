package com.young.myoauth2server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: yang zheng wu
 * @date: 2021/5/7
 * @description:
 */
@TableName("role")
@Data
public class Role {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    /**是否可用*/
    private Integer enabled;


}
