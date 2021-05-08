package com.young.myoauth2server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.myoauth2server.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yang zheng wu
 * @date: 2021/5/7
 * @description:
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {


    List<String> getPermissionCodeList(@Param("userId") Long userId);
}
