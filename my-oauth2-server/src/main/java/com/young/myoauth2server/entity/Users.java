package com.young.myoauth2server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    /**是否可用*/
    private Integer enabled;

//    /**账户是否已经过期*/
//    private Integer accountNonExpired;
//
//    /**账户是否已经所以*/
//    private Integer accountNonLocked;
//
//    /**凭证是否已经过期*/
//    private Integer credentialsNonExpired;

}
