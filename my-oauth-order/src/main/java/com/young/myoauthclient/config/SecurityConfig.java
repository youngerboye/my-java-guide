package com.young.myoauthclient.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@Order(101)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 指定令牌管理方式
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        // redis 管理令牌
//        return new RedisTokenStore(redisConnectionFactory);
        // 注入数据源
        return new JdbcTokenStore(dataSource());
        // 使用JWT管理令牌
//        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }


}
