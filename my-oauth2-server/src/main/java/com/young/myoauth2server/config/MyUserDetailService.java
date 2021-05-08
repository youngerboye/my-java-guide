package com.young.myoauth2server.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.young.myoauth2server.entity.Permissions;
import com.young.myoauth2server.entity.Users;
import com.young.myoauth2server.mapper.AuthoritiesMapper;
import com.young.myoauth2server.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersMapper.selectOne(new LambdaQueryWrapper<Users>().eq(Users::getUsername, username));
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Long usersId = users.getId();
        List<String> permissionCodeList = usersMapper.getPermissionCodeList(usersId);
        permissionCodeList = permissionCodeList.stream().filter(e-> !StringUtils.isEmpty(e)).collect(Collectors.toList());
        List<SimpleGrantedAuthority> collect = permissionCodeList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new MyUserDetails(username, users.getPassword(), users.getEnabled(), collect);
    }
}
