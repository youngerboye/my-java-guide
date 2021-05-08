package com.young.myoauth2server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: yangzhengwu
 * @date: 2021/5/7
 * @description:
 */
@Data
@TableName("permissions")
public class Permissions {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**权限名称*/
    private String name;

    /**权限字符*/
    private String permissionCode;

    /**类型 menu,button*/
    private String type;

    /**父结点id*/
    private String parentId;

    /**父结点id列表串*/
    private String parentIds;

    /**权限路径*/
    private String url;

    private Integer enabled;
}
