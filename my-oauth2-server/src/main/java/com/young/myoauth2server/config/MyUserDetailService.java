package com.young.myoauth2server.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.young.myoauth2server.entity.Authorities;
import com.young.myoauth2server.entity.MyUserDetails;
import com.young.myoauth2server.entity.Users;
import com.young.myoauth2server.mapper.AuthoritiesMapper;
import com.young.myoauth2server.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersMapper.selectOne(new LambdaQueryWrapper<Users>().eq(Users::getUsername, username));
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Authorities> authoritiesList = authoritiesMapper.selectList(new LambdaQueryWrapper<Authorities>().eq(Authorities::getUsername, username));
        Set<String> authrities = authoritiesList.stream().map(Authorities::getAuthority).collect(Collectors.toSet());

        List<SimpleGrantedAuthority> collect = authrities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new MyUserDetails(username, users.getPassword(), users.getEnabled(), collect);
    }
}
