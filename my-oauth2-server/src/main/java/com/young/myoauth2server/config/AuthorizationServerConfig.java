//package com.young.myoauth2server.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * 认证服务器配置
// * Created by macro on 2019/9/30.
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private MyUserDetailService myUserDetailService;
//
//    @Autowired
//    private DataSource dataSource;
//
//    public AuthorizationServerConfig(MyUserDetailService myUserDetailService) {
//        this.myUserDetailService = myUserDetailService;
//    }
//
//    @Bean
//    public TokenStore jdbcTokenStore(){
//        return new JdbcTokenStore(dataSource);
//    }
//
//    /**
//     * 使用密码模式需要配置
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints.authenticationManager(authenticationManager)
//                .tokenStore(jdbcTokenStore());
//    }
//
//    @Bean
//    public ClientDetailsService jdbcClientDetailsService() {
//        return new JdbcClientDetailsService(dataSource);
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("admin")//配置client_id
//                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
//                .accessTokenValiditySeconds(3600)//配置访问token的有效期
//                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
////                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
//                .redirectUris("http://localhost:9501/login")
//                .autoApprove(true)//自动授权
//                .scopes("all")//配置申请的权限范围
//                .authorizedGrantTypes("authorization_code","password");//配置grant_type，表示授权类型
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) {
//        security.tokenKeyAccess("isAuthenticated()"); // 获取密钥需要身份认证，使用单点登录时必须配置
//    }
//}
