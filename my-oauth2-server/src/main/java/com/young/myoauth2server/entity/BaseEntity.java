package com.young.myoauth2server.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author: yang zheng wu
 * @date: 2021/5/7
 * @description:
 */
public class BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    private Date creationDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdatedDate;

    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    @TableField(fill = FieldFill.INSERT)
    private Long lastUpdatedBy;


}
